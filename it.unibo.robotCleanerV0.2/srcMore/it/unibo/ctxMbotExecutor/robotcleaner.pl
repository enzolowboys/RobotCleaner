%====================================================================================
% Context ctxMbotExecutor  SYSTEM-configuration: file it.unibo.ctxMbotExecutor.robotCleaner.pl 
%====================================================================================
context(ctxrobotcleaner, "localhost",  "TCP", "8032" ).  		 
context(ctxmbotexecutor, "localhost",  "TCP", "8029" ).  		 
%%% -------------------------------------------
qactor( mbotcleanercontroller , ctxrobotcleaner, "it.unibo.mbotcleanercontroller.MsgHandle_Mbotcleanercontroller"   ). %%store msgs 
qactor( mbotcleanercontroller_ctrl , ctxrobotcleaner, "it.unibo.mbotcleanercontroller.Mbotcleanercontroller"   ). %%control-driven 
qactor( tester , ctxrobotcleaner, "it.unibo.tester.MsgHandle_Tester"   ). %%store msgs 
qactor( tester_ctrl , ctxrobotcleaner, "it.unibo.tester.Tester"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxmbotexecutor,"it.unibo.ctxMbotExecutor.Evh","tempSensor").  
eventhandler(evh2,ctxmbotexecutor,"it.unibo.ctxMbotExecutor.Evh2","usercmd").  
%%% -------------------------------------------

