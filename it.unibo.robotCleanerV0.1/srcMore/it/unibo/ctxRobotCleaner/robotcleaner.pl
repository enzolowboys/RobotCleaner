%====================================================================================
% Context ctxRobotCleaner  SYSTEM-configuration: file it.unibo.ctxRobotCleaner.robotCleaner.pl 
%====================================================================================
context(ctxrobotcleaner, "localhost",  "TCP", "8032" ).  		 
%%% -------------------------------------------
qactor( mbotcleaner , ctxrobotcleaner, "it.unibo.mbotcleaner.MsgHandle_Mbotcleaner"   ). %%store msgs 
qactor( mbotcleaner_ctrl , ctxrobotcleaner, "it.unibo.mbotcleaner.Mbotcleaner"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh,ctxrobotcleaner,"it.unibo.ctxRobotCleaner.Evh","dataSensor").  
eventhandler(evh2,ctxrobotcleaner,"it.unibo.ctxRobotCleaner.Evh2","usercmd").  
%%% -------------------------------------------

