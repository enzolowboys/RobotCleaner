%====================================================================================
% Context ctxRobotCleaner  SYSTEM-configuration: file it.unibo.ctxRobotCleaner.robotagent.pl 
%====================================================================================
context(ctxrobotcleaner, "localhost",  "TCP", "8040" ).  		 
%%% -------------------------------------------
qactor( mbotagent , ctxrobotcleaner, "it.unibo.mbotagent.MsgHandle_Mbotagent"   ). %%store msgs 
qactor( mbotagent_ctrl , ctxrobotcleaner, "it.unibo.mbotagent.Mbotagent"   ). %%control-driven 
qactor( roverobstacleavoiadanceagent , ctxrobotcleaner, "it.unibo.roverobstacleavoiadanceagent.MsgHandle_Roverobstacleavoiadanceagent"   ). %%store msgs 
qactor( roverobstacleavoiadanceagent_ctrl , ctxrobotcleaner, "it.unibo.roverobstacleavoiadanceagent.Roverobstacleavoiadanceagent"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

