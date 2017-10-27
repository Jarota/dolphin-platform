package com.canoo.dp.impl.remoting.codec.encoders;

import com.canoo.dp.impl.platform.core.Assert;
import com.canoo.dp.impl.remoting.legacy.communication.DeletePresentationModelCommand;
import com.google.gson.JsonObject;
import org.apiguardian.api.API;

import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.DELETE_PRESENTATION_MODEL_COMMAND_ID;
import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.ID;
import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.PM_ID;
import static org.apiguardian.api.API.Status.INTERNAL;

@API(since = "0.x", status = INTERNAL)
public class DeletePresentationModelCommandEncoder extends AbstractCommandTranscoder<DeletePresentationModelCommand> {

    @Override
    public JsonObject encode(DeletePresentationModelCommand command) {
        Assert.requireNonNull(command, "command");
        final JsonObject jsonCommand = new JsonObject();
        jsonCommand.addProperty(ID, DELETE_PRESENTATION_MODEL_COMMAND_ID);
        jsonCommand.addProperty(PM_ID, command.getPmId());
        return jsonCommand;
    }

    @Override
    public DeletePresentationModelCommand decode(JsonObject jsonObject) {
        DeletePresentationModelCommand command = new DeletePresentationModelCommand();
        command.setPmId(getStringElement(jsonObject, PM_ID));
        return command;
    }
}
