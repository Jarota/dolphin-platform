package com.canoo.dp.impl.remoting.codec.encoders;

import com.canoo.dp.impl.platform.core.Assert;
import com.canoo.dp.impl.remoting.legacy.communication.ChangeAttributeMetadataCommand;
import com.google.gson.JsonObject;
import org.apiguardian.api.API;

import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.ATTRIBUTE_ID;
import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.CHANGE_ATTRIBUTE_METADATA_COMMAND_ID;
import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.ID;
import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.NAME;
import static com.canoo.dp.impl.remoting.legacy.communication.CommandConstants.VALUE;
import static org.apiguardian.api.API.Status.DEPRECATED;

@Deprecated
@API(since = "0.x", status = DEPRECATED)
public class ChangeAttributeMetadataCommandEncoder extends AbstractCommandTranscoder<ChangeAttributeMetadataCommand> {
    @Override
    public JsonObject encode(ChangeAttributeMetadataCommand command) {
        Assert.requireNonNull(command, "command");
        final JsonObject jsonCommand = new JsonObject();
        jsonCommand.addProperty(ID, CHANGE_ATTRIBUTE_METADATA_COMMAND_ID);
        jsonCommand.addProperty(ATTRIBUTE_ID, command.getAttributeId());
        jsonCommand.addProperty(NAME, command.getMetadataName());
        jsonCommand.add(VALUE, ValueEncoder.encodeValue(command.getValue()));
        return jsonCommand;
    }

    @Override
    public ChangeAttributeMetadataCommand decode(JsonObject jsonObject) {
        ChangeAttributeMetadataCommand command = new ChangeAttributeMetadataCommand();
        command.setAttributeId(getStringElement(jsonObject, ATTRIBUTE_ID));
        command.setMetadataName(getStringElement(jsonObject, NAME));
        command.setValue(ValueEncoder.decodeValue(jsonObject.get(VALUE)));
        return command;
    }
}
