/* Generated by AN DISI Unibo */ 
package it.unibo.mbot;
import it.unibo.qactors.PlanRepeat;
import it.unibo.qactors.QActorContext;
import it.unibo.qactors.StateExecMessage;
import it.unibo.qactors.QActorUtils;
import it.unibo.is.interfaces.IOutputEnvView;
import it.unibo.qactors.action.AsynchActionResult;
import it.unibo.qactors.action.IActorAction;
import it.unibo.qactors.action.IActorAction.ActionExecMode;
import it.unibo.qactors.action.IMsgQueue;
import it.unibo.qactors.akka.QActor;
import it.unibo.qactors.StateFun;
import java.util.Stack;
import java.util.Hashtable;
import java.util.concurrent.Callable;
import alice.tuprolog.Struct;
import alice.tuprolog.Term;
import it.unibo.qactors.action.ActorTimedAction;
public abstract class AbstractMbot extends QActor { 
	protected AsynchActionResult aar = null;
	protected boolean actionResult = true;
	protected alice.tuprolog.SolveInfo sol;
	protected String planFilePath    = null;
	protected String terminationEvId = "default";
	protected String parg="";
	protected boolean bres=false;
	protected IActorAction action;
	 
	
		protected static IOutputEnvView setTheEnv(IOutputEnvView outEnvView ){
			return outEnvView;
		}
		public AbstractMbot(String actorId, QActorContext myCtx, IOutputEnvView outEnvView )  throws Exception{
			super(actorId, myCtx,  
			"./srcMore/it/unibo/mbot/WorldTheory.pl",
			setTheEnv( outEnvView )  , "init");
			this.planFilePath = "./srcMore/it/unibo/mbot/plans.txt";
	  	}
		@Override
		protected void doJob() throws Exception {
			String name  = getName().replace("_ctrl", "");
			mysupport = (IMsgQueue) QActorUtils.getQActor( name ); 
			initStateTable(); 
	 		initSensorSystem();
	 		history.push(stateTab.get( "init" ));
	  	 	autoSendStateExecMsg();
	  		//QActorContext.terminateQActorSystem(this);//todo
		} 	
		/* 
		* ------------------------------------------------------------
		* PLANS
		* ------------------------------------------------------------
		*/    
	    //genAkkaMshHandleStructure
	    protected void initStateTable(){  	
	    	stateTab.put("handleToutBuiltIn",handleToutBuiltIn);
	    	stateTab.put("init",init);
	    	stateTab.put("waitForCmd",waitForCmd);
	    	stateTab.put("execMove",execMove);
	    }
	    StateFun handleToutBuiltIn = () -> {	
	    	try{	
	    		PlanRepeat pr = PlanRepeat.setUp("handleTout",-1);
	    		String myselfName = "handleToutBuiltIn";  
	    		println( "mbot tout : stops");  
	    		repeatPlanNoTransition(pr,myselfName,"application_"+myselfName,false,false);
	    	}catch(Exception e_handleToutBuiltIn){  
	    		println( getName() + " plan=handleToutBuiltIn WARNING:" + e_handleToutBuiltIn.getMessage() );
	    		QActorContext.terminateQActorSystem(this); 
	    	}
	    };//handleToutBuiltIn
	    
	    StateFun init = () -> {	
	    try{	
	     PlanRepeat pr = PlanRepeat.setUp("init",-1);
	    	String myselfName = "init";  
	    	if( (guardVars = QActorUtils.evalTheGuard(this, " !?onRaspberry" )) != null ){
	    	it.unibo.mbot.mbotConnArduino.initRasp( myself  );
	    	}
	    	temporaryStr = "\"mbot START\"";
	    	println( temporaryStr );  
	    	//switchTo waitForCmd
	        switchToPlanAsNextState(pr, myselfName, "mbot_"+myselfName, 
	              "waitForCmd",false, false, null); 
	    }catch(Exception e_init){  
	    	 println( getName() + " plan=init WARNING:" + e_init.getMessage() );
	    	 QActorContext.terminateQActorSystem(this); 
	    }
	    };//init
	    
	    StateFun waitForCmd = () -> {	
	    try{	
	     PlanRepeat pr = PlanRepeat.setUp(getName()+"_waitForCmd",0);
	     pr.incNumIter(); 	
	    	String myselfName = "waitForCmd";  
	    	//bbb
	     msgTransition( pr,myselfName,"mbot_"+myselfName,false,
	          new StateFun[]{stateTab.get("execMove") }, 
	          new String[]{"true","M","moveMbot" },
	          3600000, "handleToutBuiltIn" );//msgTransition
	    }catch(Exception e_waitForCmd){  
	    	 println( getName() + " plan=waitForCmd WARNING:" + e_waitForCmd.getMessage() );
	    	 QActorContext.terminateQActorSystem(this); 
	    }
	    };//waitForCmd
	    
	    StateFun execMove = () -> {	
	    try{	
	     PlanRepeat pr = PlanRepeat.setUp("execMove",-1);
	    	String myselfName = "execMove";  
	    	printCurrentMessage(false);
	    	//onMsg 
	    	setCurrentMsgFromStore(); 
	    	curT = Term.createTerm("usercmd(robotgui(h(X)))");
	    	if( currentMessage != null && currentMessage.msgId().equals("moveMbot") && 
	    		pengine.unify(curT, Term.createTerm("usercmd(CMD)")) && 
	    		pengine.unify(curT, Term.createTerm( currentMessage.msgContent() ) )){ 
	    		{/* JavaLikeMove */ 
	    		it.unibo.mbot.mbotConnArduino.mbotStop(this );
	    		}
	    	}
	    	//onMsg 
	    	setCurrentMsgFromStore(); 
	    	curT = Term.createTerm("usercmd(robotgui(w(X)))");
	    	if( currentMessage != null && currentMessage.msgId().equals("moveMbot") && 
	    		pengine.unify(curT, Term.createTerm("usercmd(CMD)")) && 
	    		pengine.unify(curT, Term.createTerm( currentMessage.msgContent() ) )){ 
	    		{/* JavaLikeMove */ 
	    		it.unibo.mbot.mbotConnArduino.mbotForward(this );
	    		}
	    	}
	    	//onMsg 
	    	setCurrentMsgFromStore(); 
	    	curT = Term.createTerm("usercmd(robotgui(s(X)))");
	    	if( currentMessage != null && currentMessage.msgId().equals("moveMbot") && 
	    		pengine.unify(curT, Term.createTerm("usercmd(CMD)")) && 
	    		pengine.unify(curT, Term.createTerm( currentMessage.msgContent() ) )){ 
	    		{/* JavaLikeMove */ 
	    		it.unibo.mbot.mbotConnArduino.mbotBackward(this );
	    		}
	    	}
	    	//onMsg 
	    	setCurrentMsgFromStore(); 
	    	curT = Term.createTerm("usercmd(robotgui(a(X)))");
	    	if( currentMessage != null && currentMessage.msgId().equals("moveMbot") && 
	    		pengine.unify(curT, Term.createTerm("usercmd(CMD)")) && 
	    		pengine.unify(curT, Term.createTerm( currentMessage.msgContent() ) )){ 
	    		//println("WARNING: variable substitution not yet fully implemented " ); 
	    		{//actionseq
	    		it.unibo.mbot.mbotConnArduino.mbotLeft( myself  );
	    		//delay  ( no more reactive within a plan)
	    		aar = delayReactive(680,"" , "");
	    		if( aar.getInterrupted() ) curPlanInExec   = "execMove";
	    		if( ! aar.getGoon() ) return ;
	    		it.unibo.mbot.mbotConnArduino.mbotStop( myself  );
	    		};//actionseq
	    	}
	    	//onMsg 
	    	setCurrentMsgFromStore(); 
	    	curT = Term.createTerm("usercmd(robotgui(d(X)))");
	    	if( currentMessage != null && currentMessage.msgId().equals("moveMbot") && 
	    		pengine.unify(curT, Term.createTerm("usercmd(CMD)")) && 
	    		pengine.unify(curT, Term.createTerm( currentMessage.msgContent() ) )){ 
	    		//println("WARNING: variable substitution not yet fully implemented " ); 
	    		{//actionseq
	    		it.unibo.mbot.mbotConnArduino.mbotRight( myself  );
	    		//delay  ( no more reactive within a plan)
	    		aar = delayReactive(680,"" , "");
	    		if( aar.getInterrupted() ) curPlanInExec   = "execMove";
	    		if( ! aar.getGoon() ) return ;
	    		it.unibo.mbot.mbotConnArduino.mbotStop( myself  );
	    		};//actionseq
	    	}
	    	//onMsg 
	    	setCurrentMsgFromStore(); 
	    	curT = Term.createTerm("usercmd(robotgui(f(X)))");
	    	if( currentMessage != null && currentMessage.msgId().equals("moveMbot") && 
	    		pengine.unify(curT, Term.createTerm("usercmd(CMD)")) && 
	    		pengine.unify(curT, Term.createTerm( currentMessage.msgContent() ) )){ 
	    		{/* JavaLikeMove */ 
	    		it.unibo.mbot.mbotConnArduino.mbotLinefollow(this );
	    		}
	    	}
	    	repeatPlanNoTransition(pr,myselfName,"mbot_"+myselfName,false,true);
	    }catch(Exception e_execMove){  
	    	 println( getName() + " plan=execMove WARNING:" + e_execMove.getMessage() );
	    	 QActorContext.terminateQActorSystem(this); 
	    }
	    };//execMove
	    
	    protected void initSensorSystem(){
	    	//doing nothing in a QActor
	    }
	
	}
