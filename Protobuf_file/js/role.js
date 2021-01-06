/*eslint-disable block-scoped-var, no-redeclare, no-control-regex, no-prototype-builtins*/
"use strict";

var $protobuf = require("protobufjs/minimal");

// Common aliases
var $Reader = $protobuf.Reader, $Writer = $protobuf.Writer, $util = $protobuf.util;

// Exported root namespace
var $root = $protobuf.roots["default"] || ($protobuf.roots["default"] = {});

$root.Message = (function() {

    /**
     * Properties of a Message.
     * @exports IMessage
     * @interface IMessage
     * @property {Message.MsgType|null} [msgType] Message msgType
     * @property {ITest1Msg|null} [test1] Message test1
     * @property {IGame|null} [game] Message game
     */

    /**
     * Constructs a new Message.
     * @exports Message
     * @classdesc Represents a Message.
     * @implements IMessage
     * @constructor
     * @param {IMessage=} [properties] Properties to set
     */
    function Message(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * Message msgType.
     * @member {Message.MsgType} msgType
     * @memberof Message
     * @instance
     */
    Message.prototype.msgType = 0;

    /**
     * Message test1.
     * @member {ITest1Msg|null|undefined} test1
     * @memberof Message
     * @instance
     */
    Message.prototype.test1 = null;

    /**
     * Message game.
     * @member {IGame|null|undefined} game
     * @memberof Message
     * @instance
     */
    Message.prototype.game = null;

    // OneOf field names bound to virtual getters and setters
    var $oneOfFields;

    /**
     * Message msgBody.
     * @member {"test1"|"game"|undefined} msgBody
     * @memberof Message
     * @instance
     */
    Object.defineProperty(Message.prototype, "msgBody", {
        get: $util.oneOfGetter($oneOfFields = ["test1", "game"]),
        set: $util.oneOfSetter($oneOfFields)
    });

    /**
     * Creates a new Message instance using the specified properties.
     * @function create
     * @memberof Message
     * @static
     * @param {IMessage=} [properties] Properties to set
     * @returns {Message} Message instance
     */
    Message.create = function create(properties) {
        return new Message(properties);
    };

    /**
     * Encodes the specified Message message. Does not implicitly {@link Message.verify|verify} messages.
     * @function encode
     * @memberof Message
     * @static
     * @param {IMessage} message Message message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    Message.encode = function encode(message, writer) {
        if (!writer)
            writer = $Writer.create();
        if (message.msgType != null && message.hasOwnProperty("msgType"))
            writer.uint32(/* id 1, wireType 0 =*/8).int32(message.msgType);
        if (message.test1 != null && message.hasOwnProperty("test1"))
            $root.Test1Msg.encode(message.test1, writer.uint32(/* id 2, wireType 2 =*/18).fork()).ldelim();
        if (message.game != null && message.hasOwnProperty("game"))
            $root.Game.encode(message.game, writer.uint32(/* id 3, wireType 2 =*/26).fork()).ldelim();
        return writer;
    };

    /**
     * Encodes the specified Message message, length delimited. Does not implicitly {@link Message.verify|verify} messages.
     * @function encodeDelimited
     * @memberof Message
     * @static
     * @param {IMessage} message Message message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    Message.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a Message message from the specified reader or buffer.
     * @function decode
     * @memberof Message
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {Message} Message
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    Message.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.Message();
        while (reader.pos < end) {
            var tag = reader.uint32();
            switch (tag >>> 3) {
            case 1:
                message.msgType = reader.int32();
                break;
            case 2:
                message.test1 = $root.Test1Msg.decode(reader, reader.uint32());
                break;
            case 3:
                message.game = $root.Game.decode(reader, reader.uint32());
                break;
            default:
                reader.skipType(tag & 7);
                break;
            }
        }
        return message;
    };

    /**
     * Decodes a Message message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof Message
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {Message} Message
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    Message.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a Message message.
     * @function verify
     * @memberof Message
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    Message.verify = function verify(message) {
        if (typeof message !== "object" || message === null)
            return "object expected";
        var properties = {};
        if (message.msgType != null && message.hasOwnProperty("msgType"))
            switch (message.msgType) {
            default:
                return "msgType: enum value expected";
            case 0:
            case 1:
            case 2:
                break;
            }
        if (message.test1 != null && message.hasOwnProperty("test1")) {
            properties.msgBody = 1;
            {
                var error = $root.Test1Msg.verify(message.test1);
                if (error)
                    return "test1." + error;
            }
        }
        if (message.game != null && message.hasOwnProperty("game")) {
            if (properties.msgBody === 1)
                return "msgBody: multiple values";
            properties.msgBody = 1;
            {
                var error = $root.Game.verify(message.game);
                if (error)
                    return "game." + error;
            }
        }
        return null;
    };

    /**
     * Creates a Message message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof Message
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {Message} Message
     */
    Message.fromObject = function fromObject(object) {
        if (object instanceof $root.Message)
            return object;
        var message = new $root.Message();
        switch (object.msgType) {
        case "UNIVERSAL":
        case 0:
            message.msgType = 0;
            break;
        case "TEST1":
        case 1:
            message.msgType = 1;
            break;
        case "GAME":
        case 2:
            message.msgType = 2;
            break;
        }
        if (object.test1 != null) {
            if (typeof object.test1 !== "object")
                throw TypeError(".Message.test1: object expected");
            message.test1 = $root.Test1Msg.fromObject(object.test1);
        }
        if (object.game != null) {
            if (typeof object.game !== "object")
                throw TypeError(".Message.game: object expected");
            message.game = $root.Game.fromObject(object.game);
        }
        return message;
    };

    /**
     * Creates a plain object from a Message message. Also converts values to other types if specified.
     * @function toObject
     * @memberof Message
     * @static
     * @param {Message} message Message
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    Message.toObject = function toObject(message, options) {
        if (!options)
            options = {};
        var object = {};
        if (options.defaults)
            object.msgType = options.enums === String ? "UNIVERSAL" : 0;
        if (message.msgType != null && message.hasOwnProperty("msgType"))
            object.msgType = options.enums === String ? $root.Message.MsgType[message.msgType] : message.msgType;
        if (message.test1 != null && message.hasOwnProperty("test1")) {
            object.test1 = $root.Test1Msg.toObject(message.test1, options);
            if (options.oneofs)
                object.msgBody = "test1";
        }
        if (message.game != null && message.hasOwnProperty("game")) {
            object.game = $root.Game.toObject(message.game, options);
            if (options.oneofs)
                object.msgBody = "game";
        }
        return object;
    };

    /**
     * Converts this Message to JSON.
     * @function toJSON
     * @memberof Message
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    Message.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    /**
     * MsgType enum.
     * @name Message.MsgType
     * @enum {string}
     * @property {number} UNIVERSAL=0 UNIVERSAL value
     * @property {number} TEST1=1 TEST1 value
     * @property {number} GAME=2 GAME value
     */
    Message.MsgType = (function() {
        var valuesById = {}, values = Object.create(valuesById);
        values[valuesById[0] = "UNIVERSAL"] = 0;
        values[valuesById[1] = "TEST1"] = 1;
        values[valuesById[2] = "GAME"] = 2;
        return values;
    })();

    return Message;
})();

$root.Test1Msg = (function() {

    /**
     * Properties of a Test1Msg.
     * @exports ITest1Msg
     * @interface ITest1Msg
     * @property {number|null} [id] Test1Msg id
     * @property {string|null} [name] Test1Msg name
     * @property {number|null} [age] Test1Msg age
     * @property {number|null} [state] Test1Msg state
     */

    /**
     * Constructs a new Test1Msg.
     * @exports Test1Msg
     * @classdesc Represents a Test1Msg.
     * @implements ITest1Msg
     * @constructor
     * @param {ITest1Msg=} [properties] Properties to set
     */
    function Test1Msg(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * Test1Msg id.
     * @member {number} id
     * @memberof Test1Msg
     * @instance
     */
    Test1Msg.prototype.id = 0;

    /**
     * Test1Msg name.
     * @member {string} name
     * @memberof Test1Msg
     * @instance
     */
    Test1Msg.prototype.name = "";

    /**
     * Test1Msg age.
     * @member {number} age
     * @memberof Test1Msg
     * @instance
     */
    Test1Msg.prototype.age = 0;

    /**
     * Test1Msg state.
     * @member {number} state
     * @memberof Test1Msg
     * @instance
     */
    Test1Msg.prototype.state = 0;

    /**
     * Creates a new Test1Msg instance using the specified properties.
     * @function create
     * @memberof Test1Msg
     * @static
     * @param {ITest1Msg=} [properties] Properties to set
     * @returns {Test1Msg} Test1Msg instance
     */
    Test1Msg.create = function create(properties) {
        return new Test1Msg(properties);
    };

    /**
     * Encodes the specified Test1Msg message. Does not implicitly {@link Test1Msg.verify|verify} messages.
     * @function encode
     * @memberof Test1Msg
     * @static
     * @param {ITest1Msg} message Test1Msg message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    Test1Msg.encode = function encode(message, writer) {
        if (!writer)
            writer = $Writer.create();
        if (message.id != null && message.hasOwnProperty("id"))
            writer.uint32(/* id 1, wireType 0 =*/8).int32(message.id);
        if (message.name != null && message.hasOwnProperty("name"))
            writer.uint32(/* id 2, wireType 2 =*/18).string(message.name);
        if (message.age != null && message.hasOwnProperty("age"))
            writer.uint32(/* id 3, wireType 0 =*/24).int32(message.age);
        if (message.state != null && message.hasOwnProperty("state"))
            writer.uint32(/* id 4, wireType 0 =*/32).int32(message.state);
        return writer;
    };

    /**
     * Encodes the specified Test1Msg message, length delimited. Does not implicitly {@link Test1Msg.verify|verify} messages.
     * @function encodeDelimited
     * @memberof Test1Msg
     * @static
     * @param {ITest1Msg} message Test1Msg message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    Test1Msg.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a Test1Msg message from the specified reader or buffer.
     * @function decode
     * @memberof Test1Msg
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {Test1Msg} Test1Msg
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    Test1Msg.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.Test1Msg();
        while (reader.pos < end) {
            var tag = reader.uint32();
            switch (tag >>> 3) {
            case 1:
                message.id = reader.int32();
                break;
            case 2:
                message.name = reader.string();
                break;
            case 3:
                message.age = reader.int32();
                break;
            case 4:
                message.state = reader.int32();
                break;
            default:
                reader.skipType(tag & 7);
                break;
            }
        }
        return message;
    };

    /**
     * Decodes a Test1Msg message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof Test1Msg
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {Test1Msg} Test1Msg
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    Test1Msg.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a Test1Msg message.
     * @function verify
     * @memberof Test1Msg
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    Test1Msg.verify = function verify(message) {
        if (typeof message !== "object" || message === null)
            return "object expected";
        if (message.id != null && message.hasOwnProperty("id"))
            if (!$util.isInteger(message.id))
                return "id: integer expected";
        if (message.name != null && message.hasOwnProperty("name"))
            if (!$util.isString(message.name))
                return "name: string expected";
        if (message.age != null && message.hasOwnProperty("age"))
            if (!$util.isInteger(message.age))
                return "age: integer expected";
        if (message.state != null && message.hasOwnProperty("state"))
            if (!$util.isInteger(message.state))
                return "state: integer expected";
        return null;
    };

    /**
     * Creates a Test1Msg message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof Test1Msg
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {Test1Msg} Test1Msg
     */
    Test1Msg.fromObject = function fromObject(object) {
        if (object instanceof $root.Test1Msg)
            return object;
        var message = new $root.Test1Msg();
        if (object.id != null)
            message.id = object.id | 0;
        if (object.name != null)
            message.name = String(object.name);
        if (object.age != null)
            message.age = object.age | 0;
        if (object.state != null)
            message.state = object.state | 0;
        return message;
    };

    /**
     * Creates a plain object from a Test1Msg message. Also converts values to other types if specified.
     * @function toObject
     * @memberof Test1Msg
     * @static
     * @param {Test1Msg} message Test1Msg
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    Test1Msg.toObject = function toObject(message, options) {
        if (!options)
            options = {};
        var object = {};
        if (options.defaults) {
            object.id = 0;
            object.name = "";
            object.age = 0;
            object.state = 0;
        }
        if (message.id != null && message.hasOwnProperty("id"))
            object.id = message.id;
        if (message.name != null && message.hasOwnProperty("name"))
            object.name = message.name;
        if (message.age != null && message.hasOwnProperty("age"))
            object.age = message.age;
        if (message.state != null && message.hasOwnProperty("state"))
            object.state = message.state;
        return object;
    };

    /**
     * Converts this Test1Msg to JSON.
     * @function toJSON
     * @memberof Test1Msg
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    Test1Msg.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    return Test1Msg;
})();

$root.Game = (function() {

    /**
     * Properties of a Game.
     * @exports IGame
     * @interface IGame
     * @property {string|null} [gamename] Game gamename
     * @property {number|null} [num] Game num
     */

    /**
     * Constructs a new Game.
     * @exports Game
     * @classdesc Represents a Game.
     * @implements IGame
     * @constructor
     * @param {IGame=} [properties] Properties to set
     */
    function Game(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * Game gamename.
     * @member {string} gamename
     * @memberof Game
     * @instance
     */
    Game.prototype.gamename = "";

    /**
     * Game num.
     * @member {number} num
     * @memberof Game
     * @instance
     */
    Game.prototype.num = 0;

    /**
     * Creates a new Game instance using the specified properties.
     * @function create
     * @memberof Game
     * @static
     * @param {IGame=} [properties] Properties to set
     * @returns {Game} Game instance
     */
    Game.create = function create(properties) {
        return new Game(properties);
    };

    /**
     * Encodes the specified Game message. Does not implicitly {@link Game.verify|verify} messages.
     * @function encode
     * @memberof Game
     * @static
     * @param {IGame} message Game message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    Game.encode = function encode(message, writer) {
        if (!writer)
            writer = $Writer.create();
        if (message.gamename != null && message.hasOwnProperty("gamename"))
            writer.uint32(/* id 1, wireType 2 =*/10).string(message.gamename);
        if (message.num != null && message.hasOwnProperty("num"))
            writer.uint32(/* id 2, wireType 0 =*/16).int32(message.num);
        return writer;
    };

    /**
     * Encodes the specified Game message, length delimited. Does not implicitly {@link Game.verify|verify} messages.
     * @function encodeDelimited
     * @memberof Game
     * @static
     * @param {IGame} message Game message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    Game.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a Game message from the specified reader or buffer.
     * @function decode
     * @memberof Game
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {Game} Game
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    Game.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.Game();
        while (reader.pos < end) {
            var tag = reader.uint32();
            switch (tag >>> 3) {
            case 1:
                message.gamename = reader.string();
                break;
            case 2:
                message.num = reader.int32();
                break;
            default:
                reader.skipType(tag & 7);
                break;
            }
        }
        return message;
    };

    /**
     * Decodes a Game message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof Game
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {Game} Game
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    Game.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a Game message.
     * @function verify
     * @memberof Game
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    Game.verify = function verify(message) {
        if (typeof message !== "object" || message === null)
            return "object expected";
        if (message.gamename != null && message.hasOwnProperty("gamename"))
            if (!$util.isString(message.gamename))
                return "gamename: string expected";
        if (message.num != null && message.hasOwnProperty("num"))
            if (!$util.isInteger(message.num))
                return "num: integer expected";
        return null;
    };

    /**
     * Creates a Game message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof Game
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {Game} Game
     */
    Game.fromObject = function fromObject(object) {
        if (object instanceof $root.Game)
            return object;
        var message = new $root.Game();
        if (object.gamename != null)
            message.gamename = String(object.gamename);
        if (object.num != null)
            message.num = object.num | 0;
        return message;
    };

    /**
     * Creates a plain object from a Game message. Also converts values to other types if specified.
     * @function toObject
     * @memberof Game
     * @static
     * @param {Game} message Game
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    Game.toObject = function toObject(message, options) {
        if (!options)
            options = {};
        var object = {};
        if (options.defaults) {
            object.gamename = "";
            object.num = 0;
        }
        if (message.gamename != null && message.hasOwnProperty("gamename"))
            object.gamename = message.gamename;
        if (message.num != null && message.hasOwnProperty("num"))
            object.num = message.num;
        return object;
    };

    /**
     * Converts this Game to JSON.
     * @function toJSON
     * @memberof Game
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    Game.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    return Game;
})();

module.exports = $root;
