package com.canoo.dp.impl.remoting.codec.encoders;

import com.canoo.dp.impl.platform.core.Assert;
import com.canoo.dp.impl.remoting.commands.CreateContextCommand;
import com.google.gson.JsonObject;
import org.apiguardian.api.API;

import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.CREATE_CONTEXT_COMMAND_ID;
import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.ID;
import static org.apiguardian.api.API.Status.INTERNAL;

@API(since = "0.x", status = INTERNAL)
public class CreateContextCommandEncoder extends AbstractCommandTranscoder<CreateContextCommand> {
    @Override
    public JsonObject encode(CreateContextCommand command) {
        Assert.requireNonNull(command, "command");
        final JsonObject jsonCommand = new JsonObject();
        jsonCommand.addProperty(ID, CREATE_CONTEXT_COMMAND_ID);
        return jsonCommand;
    }

    @Override
    public CreateContextCommand decode(JsonObject jsonObject) {
        return new CreateContextCommand();
    }
}
