package my;

import java.util.Map;

import blocksworld.BlocksWorld;
import blocksworld.BlocksWorldAction;
import blocksworld.DynamicEnvironment;

/**
 * Class implementing specific functionality for the environment.
 */
public class MyBlocksWorldEnvironment extends DynamicEnvironment
{
	/**
	 * @param world
	 *            - the initial world.
	 * @param dynamicity
	 *            - environment dynamicity.
	 * @param seed
	 *            - seed for the generator or -1 if to generate a seed from the time.
	 */
	public MyBlocksWorldEnvironment(BlocksWorld world, float dynamicity, long seed)
	{
		super(world, dynamicity, seed);
	}
	
	@Override
	protected int performActions(Map<AgentData, BlocksWorldAction> actionMap)
	{
		// TODO solve conflicts if there are multiple agents.
		return super.performActions(actionMap);
	}
	
	@Override
	protected boolean hasToken(AgentData agent)
	{
		// TODO return if an agent has the token or not.
		return super.hasToken(agent);
	}
}
