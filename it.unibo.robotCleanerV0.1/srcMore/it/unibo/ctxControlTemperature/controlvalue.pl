%====================================================================================
% Context ctxControlTemperature  SYSTEM-configuration: file it.unibo.ctxControlTemperature.controlValue.pl 
%====================================================================================
context(ctxcontroltemperature, "localhost",  "TCP", "8033" ).  		 
context(ctxrobotcleaner, "localhost",  "TCP", "8032" ).  		 
context(ctxconsolerobotgui, "localhost",  "TCP", "8034" ).  		 
%%% -------------------------------------------
qactor( sendtemperaturecontroller , ctxcontroltemperature, "it.unibo.sendtemperaturecontroller.MsgHandle_Sendtemperaturecontroller"   ). %%store msgs 
qactor( sendtemperaturecontroller_ctrl , ctxcontroltemperature, "it.unibo.sendtemperaturecontroller.Sendtemperaturecontroller"   ). %%control-driven 
%%% -------------------------------------------
%%% -------------------------------------------

