%====================================================================================
% Context ctxprova  SYSTEM-configuration: file it.unibo.ctxprova.consoleControlValue.pl 
%====================================================================================
context(ctxprova, "localhost",  "TCP", "8029" ).  		 
%%% -------------------------------------------
qactor( prova , ctxprova, "it.unibo.prova.MsgHandle_Prova"   ). %%store msgs 
qactor( prova_ctrl , ctxprova, "it.unibo.prova.Prova"   ). %%control-driven 
%%% -------------------------------------------
eventhandler(evh2,ctxprova,"it.unibo.ctxprova.Evh2","usercmd").  
%%% -------------------------------------------

