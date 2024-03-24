package my;

import java.util.List;

import base.Action;
import base.Agent;
import base.Perceptions;
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
			Type stackType = Type.STACK;

			BlocksWorldAction stackAction = new BlocksWorldAction(stackType);
			plan.addAction(stackAction);

			Type unstackType = Type.UNSTACK;
			BlocksWorldAction unstackAction = new BlocksWorldAction(unstackType);
			plan.addAction(unstackAction);
		}

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
