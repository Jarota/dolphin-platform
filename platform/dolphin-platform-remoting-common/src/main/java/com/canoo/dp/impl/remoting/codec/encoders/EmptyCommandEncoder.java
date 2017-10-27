package com.canoo.dp.impl.remoting.codec.encoders;

import com.canoo.dp.impl.platform.core.Assert;
import com.canoo.dp.impl.remoting.legacy.communication.EmptyCommand;
import com.google.gson.JsonObject;
import org.apiguardian.api.API;

import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.EMPTY_COMMAND_ID;
import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.ID;
import static org.apiguardian.api.API.Status.DEPRECATED;

@Deprecated
@API(since = "0.x", status = DEPRECATED)
public class EmptyCommandEncoder extends AbstractCommandTranscoder<EmptyCommand> {
    @Override
    public JsonObject encode(EmptyCommand command) {
        Assert.requireNonNull(command, "command");
        final JsonObject jsonCommand = new JsonObject();
        jsonCommand.addProperty(ID, EMPTY_COMMAND_ID);
        return jsonCommand;
    }

    @Override
    public EmptyCommand decode(JsonObject jsonObject) {
        return new EmptyCommand();
    }
}
