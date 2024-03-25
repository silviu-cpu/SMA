package my;

import java.util.List;

import base.Action;
import base.Agent;
import base.Perceptions;
import blocksworld.Block;
import blocksworld.BlocksWorld;
import blocksworld.BlocksWorldAction;
import blocksworld.BlocksWorldAction.Type;
import blocksworld.BlocksWorldPerceptions;
import blocksworld.PlanningAction;
import blocksworld.PlanningAction.PlanningActionType;
import blocksworld.Stack;

/**
 * Agent to implement.
 */
public class MyAgent implements Agent {
	/**
	 * Name of the agent.
	 */
	String agentName;

	/**
	 * Constructor for the agent.
	 * 
	 * @param desiredState
	 *                     - the desired state of the world.
	 * @param name
	 *                     - the name of the agent.
	 */
	public MyAgent(BlocksWorld desiredState, String name) {
		agentName = name;

		// Perceptions perceptions = new BlocksWorldPerceptions(null, null, null, false,
		// null);
		// Action action = myAgent.response(perceptions);

		// TODO
		// trecem prin toate statiile
		// construium un plan nou
		// intoarcem un plan nou
	}

	@Override
	public Action response(Perceptions input) {
		@SuppressWarnings("unused")
		BlocksWorldPerceptions perceptions = (BlocksWorldPerceptions) input;

		System.out.println("---Perceptions-----");
		System.out.println(perceptions.getVisibleStack());
		System.out.println("-----------");

		System.out.println("---Current Station-----");
		System.out.println(perceptions.getCurrentStation());
		System.out.println("-----------");

		PlanningAction plan = new PlanningAction(PlanningActionType.NEW_PLAN);
		Type actionType = Type.NEXT_STATION;
		BlocksWorldAction action = new BlocksWorldAction(actionType);
		plan.addAction(action);

		System.out.println("---Remain Plan-----");
		System.out.println(perceptions.getRemainingPlan());
		System.out.println("-----------");

		if (perceptions.getRemainingPlan() != null) {
			plan = new PlanningAction(PlanningActionType.CONTINUE_PLAN);

		}

		Block blockA = new Block('A');
		Block blockB = new Block('B');
		Block blockC = new Block('C');

		BlocksWorldAction unstackAction = new BlocksWorldAction(Type.UNSTACK, blockA, blockB);
		plan.addAction(unstackAction);

		BlocksWorldAction pickupAction = new BlocksWorldAction(Type.PICKUP, blockB);
		BlocksWorldAction stackAction = new BlocksWorldAction(Type.STACK, blockB, blockC);
		BlocksWorldAction putdownAction = new BlocksWorldAction(Type.PUTDOWN, blockB);

		plan.addAction(pickupAction);
		plan.addAction(stackAction);
		plan.addAction(putdownAction);

		// TODO: revise beliefs; if necessary, make a plan; return an action.

		return plan;
	}

	@Override
	public String statusString() {
		// TODO: return information about the agent's current state and current plan.
		return toString() + ": All good.";
	}

	@Override
	public String toString() {
		return "" + agentName;
	}
}
