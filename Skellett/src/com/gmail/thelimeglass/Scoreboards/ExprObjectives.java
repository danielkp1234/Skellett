package com.gmail.thelimeglass.Scoreboards;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;

public class ExprObjectives extends SimpleExpression<Objective> {
	
	//[(the|all)] [of] [the] (score[ ][board]|board)[[']s] objectives
	
	@Override
	public boolean isSingle() {
		return false;
	}
	@Override
	public Class<? extends Objective> getReturnType() {
		return Objective.class;
	}
	@Override
	public String toString(Event event, boolean b) {
		return "[(the|all)] [of] [the] (score[ ][board]|board)[[']s] objectives";
	}
	@Override
	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
		return true;
	}
	@Override
	protected Objective[] get(final Event e) {
		Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
		ArrayList<Objective> objectives = new ArrayList<>();
		for (Objective obj : board.getObjectives()) {
			objectives.add(obj);
		}
		return objectives.toArray(new Objective[objectives.size()]);
	}
}