/*eslint-disable block-scoped-var, no-redeclare, no-control-regex, no-prototype-builtins*/
"use strict";

var $protobuf = require("protobufjs/minimal");

// Common aliases
var $Reader = $protobuf.Reader, $Writer = $protobuf.Writer, $util = $protobuf.util;

// Exported root namespace
var $root = $protobuf.roots["default"] || ($protobuf.roots["default"] = {});

$root.GameMessage = (function() {

    /**
     * Properties of a GameMessage.
     * @exports IGameMessage
     * @interface IGameMessage
     * @property {GameMessage.MsgType|null} [msgType] GameMessage msgType
     * @property {IC2S_initGameMessage|null} [c2sInitGame] GameMessage c2sInitGame
     * @property {IS2C_initGameMessage|null} [s2cInitGame] GameMessage s2cInitGame
     */

    /**
     * Constructs a new GameMessage.
     * @exports GameMessage
     * @classdesc Represents a GameMessage.
     * @implements IGameMessage
     * @constructor
     * @param {IGameMessage=} [properties] Properties to set
     */
    function GameMessage(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * GameMessage msgType.
     * @member {GameMessage.MsgType} msgType
     * @memberof GameMessage
     * @instance
     */
    GameMessage.prototype.msgType = 0;

    /**
     * GameMessage c2sInitGame.
     * @member {IC2S_initGameMessage|null|undefined} c2sInitGame
     * @memberof GameMessage
     * @instance
     */
    GameMessage.prototype.c2sInitGame = null;

    /**
     * GameMessage s2cInitGame.
     * @member {IS2C_initGameMessage|null|undefined} s2cInitGame
     * @memberof GameMessage
     * @instance
     */
    GameMessage.prototype.s2cInitGame = null;

    // OneOf field names bound to virtual getters and setters
    var $oneOfFields;

    /**
     * GameMessage msgBody.
     * @member {"c2sInitGame"|"s2cInitGame"|undefined} msgBody
     * @memberof GameMessage
     * @instance
     */
    Object.defineProperty(GameMessage.prototype, "msgBody", {
        get: $util.oneOfGetter($oneOfFields = ["c2sInitGame", "s2cInitGame"]),
        set: $util.oneOfSetter($oneOfFields)
    });

    /**
     * Creates a new GameMessage instance using the specified properties.
     * @function create
     * @memberof GameMessage
     * @static
     * @param {IGameMessage=} [properties] Properties to set
     * @returns {GameMessage} GameMessage instance
     */
    GameMessage.create = function create(properties) {
        return new GameMessage(properties);
    };

    /**
     * Encodes the specified GameMessage message. Does not implicitly {@link GameMessage.verify|verify} messages.
     * @function encode
     * @memberof GameMessage
     * @static
     * @param {IGameMessage} message GameMessage message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    GameMessage.encode = function encode(message, writer) {
        if (!writer)
            writer = $Writer.create();
        if (message.msgType != null && message.hasOwnProperty("msgType"))
            writer.uint32(/* id 1, wireType 0 =*/8).int32(message.msgType);
        if (message.c2sInitGame != null && message.hasOwnProperty("c2sInitGame"))
            $root.C2S_initGameMessage.encode(message.c2sInitGame, writer.uint32(/* id 2, wireType 2 =*/18).fork()).ldelim();
        if (message.s2cInitGame != null && message.hasOwnProperty("s2cInitGame"))
            $root.S2C_initGameMessage.encode(message.s2cInitGame, writer.uint32(/* id 3, wireType 2 =*/26).fork()).ldelim();
        return writer;
    };

    /**
     * Encodes the specified GameMessage message, length delimited. Does not implicitly {@link GameMessage.verify|verify} messages.
     * @function encodeDelimited
     * @memberof GameMessage
     * @static
     * @param {IGameMessage} message GameMessage message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    GameMessage.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a GameMessage message from the specified reader or buffer.
     * @function decode
     * @memberof GameMessage
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {GameMessage} GameMessage
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    GameMessage.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.GameMessage();
        while (reader.pos < end) {
            var tag = reader.uint32();
            switch (tag >>> 3) {
            case 1:
                message.msgType = reader.int32();
                break;
            case 2:
                message.c2sInitGame = $root.C2S_initGameMessage.decode(reader, reader.uint32());
                break;
            case 3:
                message.s2cInitGame = $root.S2C_initGameMessage.decode(reader, reader.uint32());
                break;
            default:
                reader.skipType(tag & 7);
                break;
            }
        }
        return message;
    };

    /**
     * Decodes a GameMessage message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof GameMessage
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {GameMessage} GameMessage
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    GameMessage.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a GameMessage message.
     * @function verify
     * @memberof GameMessage
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    GameMessage.verify = function verify(message) {
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
        if (message.c2sInitGame != null && message.hasOwnProperty("c2sInitGame")) {
            properties.msgBody = 1;
            {
                var error = $root.C2S_initGameMessage.verify(message.c2sInitGame);
                if (error)
                    return "c2sInitGame." + error;
            }
        }
        if (message.s2cInitGame != null && message.hasOwnProperty("s2cInitGame")) {
            if (properties.msgBody === 1)
                return "msgBody: multiple values";
            properties.msgBody = 1;
            {
                var error = $root.S2C_initGameMessage.verify(message.s2cInitGame);
                if (error)
                    return "s2cInitGame." + error;
            }
        }
        return null;
    };

    /**
     * Creates a GameMessage message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof GameMessage
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {GameMessage} GameMessage
     */
    GameMessage.fromObject = function fromObject(object) {
        if (object instanceof $root.GameMessage)
            return object;
        var message = new $root.GameMessage();
        switch (object.msgType) {
        case "UNIVERSAL":
        case 0:
            message.msgType = 0;
            break;
        case "C2S_initGameMessage":
        case 1:
            message.msgType = 1;
            break;
        case "S2C_initGameMessage":
        case 2:
            message.msgType = 2;
            break;
        }
        if (object.c2sInitGame != null) {
            if (typeof object.c2sInitGame !== "object")
                throw TypeError(".GameMessage.c2sInitGame: object expected");
            message.c2sInitGame = $root.C2S_initGameMessage.fromObject(object.c2sInitGame);
        }
        if (object.s2cInitGame != null) {
            if (typeof object.s2cInitGame !== "object")
                throw TypeError(".GameMessage.s2cInitGame: object expected");
            message.s2cInitGame = $root.S2C_initGameMessage.fromObject(object.s2cInitGame);
        }
        return message;
    };

    /**
     * Creates a plain object from a GameMessage message. Also converts values to other types if specified.
     * @function toObject
     * @memberof GameMessage
     * @static
     * @param {GameMessage} message GameMessage
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    GameMessage.toObject = function toObject(message, options) {
        if (!options)
            options = {};
        var object = {};
        if (options.defaults)
            object.msgType = options.enums === String ? "UNIVERSAL" : 0;
        if (message.msgType != null && message.hasOwnProperty("msgType"))
            object.msgType = options.enums === String ? $root.GameMessage.MsgType[message.msgType] : message.msgType;
        if (message.c2sInitGame != null && message.hasOwnProperty("c2sInitGame")) {
            object.c2sInitGame = $root.C2S_initGameMessage.toObject(message.c2sInitGame, options);
            if (options.oneofs)
                object.msgBody = "c2sInitGame";
        }
        if (message.s2cInitGame != null && message.hasOwnProperty("s2cInitGame")) {
            object.s2cInitGame = $root.S2C_initGameMessage.toObject(message.s2cInitGame, options);
            if (options.oneofs)
                object.msgBody = "s2cInitGame";
        }
        return object;
    };

    /**
     * Converts this GameMessage to JSON.
     * @function toJSON
     * @memberof GameMessage
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    GameMessage.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    /**
     * MsgType enum.
     * @name GameMessage.MsgType
     * @enum {string}
     * @property {number} UNIVERSAL=0 UNIVERSAL value
     * @property {number} C2S_initGameMessage=1 C2S_initGameMessage value
     * @property {number} S2C_initGameMessage=2 S2C_initGameMessage value
     */
    GameMessage.MsgType = (function() {
        var valuesById = {}, values = Object.create(valuesById);
        values[valuesById[0] = "UNIVERSAL"] = 0;
        values[valuesById[1] = "C2S_initGameMessage"] = 1;
        values[valuesById[2] = "S2C_initGameMessage"] = 2;
        return values;
    })();

    return GameMessage;
})();

$root.C2S_initGameMessage = (function() {

    /**
     * Properties of a C2S_initGameMessage.
     * @exports IC2S_initGameMessage
     * @interface IC2S_initGameMessage
     * @property {number|null} [money] C2S_initGameMessage money
     */

    /**
     * Constructs a new C2S_initGameMessage.
     * @exports C2S_initGameMessage
     * @classdesc Represents a C2S_initGameMessage.
     * @implements IC2S_initGameMessage
     * @constructor
     * @param {IC2S_initGameMessage=} [properties] Properties to set
     */
    function C2S_initGameMessage(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * C2S_initGameMessage money.
     * @member {number} money
     * @memberof C2S_initGameMessage
     * @instance
     */
    C2S_initGameMessage.prototype.money = 0;

    /**
     * Creates a new C2S_initGameMessage instance using the specified properties.
     * @function create
     * @memberof C2S_initGameMessage
     * @static
     * @param {IC2S_initGameMessage=} [properties] Properties to set
     * @returns {C2S_initGameMessage} C2S_initGameMessage instance
     */
    C2S_initGameMessage.create = function create(properties) {
        return new C2S_initGameMessage(properties);
    };

    /**
     * Encodes the specified C2S_initGameMessage message. Does not implicitly {@link C2S_initGameMessage.verify|verify} messages.
     * @function encode
     * @memberof C2S_initGameMessage
     * @static
     * @param {IC2S_initGameMessage} message C2S_initGameMessage message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    C2S_initGameMessage.encode = function encode(message, writer) {
        if (!writer)
            writer = $Writer.create();
        if (message.money != null && message.hasOwnProperty("money"))
            writer.uint32(/* id 1, wireType 0 =*/8).int32(message.money);
        return writer;
    };

    /**
     * Encodes the specified C2S_initGameMessage message, length delimited. Does not implicitly {@link C2S_initGameMessage.verify|verify} messages.
     * @function encodeDelimited
     * @memberof C2S_initGameMessage
     * @static
     * @param {IC2S_initGameMessage} message C2S_initGameMessage message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    C2S_initGameMessage.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a C2S_initGameMessage message from the specified reader or buffer.
     * @function decode
     * @memberof C2S_initGameMessage
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {C2S_initGameMessage} C2S_initGameMessage
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    C2S_initGameMessage.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.C2S_initGameMessage();
        while (reader.pos < end) {
            var tag = reader.uint32();
            switch (tag >>> 3) {
            case 1:
                message.money = reader.int32();
                break;
            default:
                reader.skipType(tag & 7);
                break;
            }
        }
        return message;
    };

    /**
     * Decodes a C2S_initGameMessage message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof C2S_initGameMessage
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {C2S_initGameMessage} C2S_initGameMessage
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    C2S_initGameMessage.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a C2S_initGameMessage message.
     * @function verify
     * @memberof C2S_initGameMessage
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    C2S_initGameMessage.verify = function verify(message) {
        if (typeof message !== "object" || message === null)
            return "object expected";
        if (message.money != null && message.hasOwnProperty("money"))
            if (!$util.isInteger(message.money))
                return "money: integer expected";
        return null;
    };

    /**
     * Creates a C2S_initGameMessage message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof C2S_initGameMessage
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {C2S_initGameMessage} C2S_initGameMessage
     */
    C2S_initGameMessage.fromObject = function fromObject(object) {
        if (object instanceof $root.C2S_initGameMessage)
            return object;
        var message = new $root.C2S_initGameMessage();
        if (object.money != null)
            message.money = object.money | 0;
        return message;
    };

    /**
     * Creates a plain object from a C2S_initGameMessage message. Also converts values to other types if specified.
     * @function toObject
     * @memberof C2S_initGameMessage
     * @static
     * @param {C2S_initGameMessage} message C2S_initGameMessage
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    C2S_initGameMessage.toObject = function toObject(message, options) {
        if (!options)
            options = {};
        var object = {};
        if (options.defaults)
            object.money = 0;
        if (message.money != null && message.hasOwnProperty("money"))
            object.money = message.money;
        return object;
    };

    /**
     * Converts this C2S_initGameMessage to JSON.
     * @function toJSON
     * @memberof C2S_initGameMessage
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    C2S_initGameMessage.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    return C2S_initGameMessage;
})();

$root.S2C_initGameMessage = (function() {

    /**
     * Properties of a S2C_initGameMessage.
     * @exports IS2C_initGameMessage
     * @interface IS2C_initGameMessage
     * @property {IRoleInfo|null} [role] S2C_initGameMessage role
     * @property {IWeatherInfo|null} [weather] S2C_initGameMessage weather
     */

    /**
     * Constructs a new S2C_initGameMessage.
     * @exports S2C_initGameMessage
     * @classdesc Represents a S2C_initGameMessage.
     * @implements IS2C_initGameMessage
     * @constructor
     * @param {IS2C_initGameMessage=} [properties] Properties to set
     */
    function S2C_initGameMessage(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * S2C_initGameMessage role.
     * @member {IRoleInfo|null|undefined} role
     * @memberof S2C_initGameMessage
     * @instance
     */
    S2C_initGameMessage.prototype.role = null;

    /**
     * S2C_initGameMessage weather.
     * @member {IWeatherInfo|null|undefined} weather
     * @memberof S2C_initGameMessage
     * @instance
     */
    S2C_initGameMessage.prototype.weather = null;

    /**
     * Creates a new S2C_initGameMessage instance using the specified properties.
     * @function create
     * @memberof S2C_initGameMessage
     * @static
     * @param {IS2C_initGameMessage=} [properties] Properties to set
     * @returns {S2C_initGameMessage} S2C_initGameMessage instance
     */
    S2C_initGameMessage.create = function create(properties) {
        return new S2C_initGameMessage(properties);
    };

    /**
     * Encodes the specified S2C_initGameMessage message. Does not implicitly {@link S2C_initGameMessage.verify|verify} messages.
     * @function encode
     * @memberof S2C_initGameMessage
     * @static
     * @param {IS2C_initGameMessage} message S2C_initGameMessage message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    S2C_initGameMessage.encode = function encode(message, writer) {
        if (!writer)
            writer = $Writer.create();
        if (message.role != null && message.hasOwnProperty("role"))
            $root.RoleInfo.encode(message.role, writer.uint32(/* id 1, wireType 2 =*/10).fork()).ldelim();
        if (message.weather != null && message.hasOwnProperty("weather"))
            $root.WeatherInfo.encode(message.weather, writer.uint32(/* id 2, wireType 2 =*/18).fork()).ldelim();
        return writer;
    };

    /**
     * Encodes the specified S2C_initGameMessage message, length delimited. Does not implicitly {@link S2C_initGameMessage.verify|verify} messages.
     * @function encodeDelimited
     * @memberof S2C_initGameMessage
     * @static
     * @param {IS2C_initGameMessage} message S2C_initGameMessage message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    S2C_initGameMessage.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a S2C_initGameMessage message from the specified reader or buffer.
     * @function decode
     * @memberof S2C_initGameMessage
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {S2C_initGameMessage} S2C_initGameMessage
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    S2C_initGameMessage.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.S2C_initGameMessage();
        while (reader.pos < end) {
            var tag = reader.uint32();
            switch (tag >>> 3) {
            case 1:
                message.role = $root.RoleInfo.decode(reader, reader.uint32());
                break;
            case 2:
                message.weather = $root.WeatherInfo.decode(reader, reader.uint32());
                break;
            default:
                reader.skipType(tag & 7);
                break;
            }
        }
        return message;
    };

    /**
     * Decodes a S2C_initGameMessage message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof S2C_initGameMessage
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {S2C_initGameMessage} S2C_initGameMessage
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    S2C_initGameMessage.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a S2C_initGameMessage message.
     * @function verify
     * @memberof S2C_initGameMessage
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    S2C_initGameMessage.verify = function verify(message) {
        if (typeof message !== "object" || message === null)
            return "object expected";
        if (message.role != null && message.hasOwnProperty("role")) {
            var error = $root.RoleInfo.verify(message.role);
            if (error)
                return "role." + error;
        }
        if (message.weather != null && message.hasOwnProperty("weather")) {
            var error = $root.WeatherInfo.verify(message.weather);
            if (error)
                return "weather." + error;
        }
        return null;
    };

    /**
     * Creates a S2C_initGameMessage message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof S2C_initGameMessage
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {S2C_initGameMessage} S2C_initGameMessage
     */
    S2C_initGameMessage.fromObject = function fromObject(object) {
        if (object instanceof $root.S2C_initGameMessage)
            return object;
        var message = new $root.S2C_initGameMessage();
        if (object.role != null) {
            if (typeof object.role !== "object")
                throw TypeError(".S2C_initGameMessage.role: object expected");
            message.role = $root.RoleInfo.fromObject(object.role);
        }
        if (object.weather != null) {
            if (typeof object.weather !== "object")
                throw TypeError(".S2C_initGameMessage.weather: object expected");
            message.weather = $root.WeatherInfo.fromObject(object.weather);
        }
        return message;
    };

    /**
     * Creates a plain object from a S2C_initGameMessage message. Also converts values to other types if specified.
     * @function toObject
     * @memberof S2C_initGameMessage
     * @static
     * @param {S2C_initGameMessage} message S2C_initGameMessage
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    S2C_initGameMessage.toObject = function toObject(message, options) {
        if (!options)
            options = {};
        var object = {};
        if (options.defaults) {
            object.role = null;
            object.weather = null;
        }
        if (message.role != null && message.hasOwnProperty("role"))
            object.role = $root.RoleInfo.toObject(message.role, options);
        if (message.weather != null && message.hasOwnProperty("weather"))
            object.weather = $root.WeatherInfo.toObject(message.weather, options);
        return object;
    };

    /**
     * Converts this S2C_initGameMessage to JSON.
     * @function toJSON
     * @memberof S2C_initGameMessage
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    S2C_initGameMessage.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    return S2C_initGameMessage;
})();

$root.RoleInfo = (function() {

    /**
     * Properties of a RoleInfo.
     * @exports IRoleInfo
     * @interface IRoleInfo
     * @property {number|null} [id] RoleInfo id
     * @property {string|null} [name] RoleInfo name
     * @property {number|null} [luckyValue] RoleInfo luckyValue
     * @property {number|null} [moodValue] RoleInfo moodValue
     * @property {number|null} [money] RoleInfo money
     * @property {Object.<string,number>|null} [eventFinishedData] RoleInfo eventFinishedData
     */

    /**
     * Constructs a new RoleInfo.
     * @exports RoleInfo
     * @classdesc Represents a RoleInfo.
     * @implements IRoleInfo
     * @constructor
     * @param {IRoleInfo=} [properties] Properties to set
     */
    function RoleInfo(properties) {
        this.eventFinishedData = {};
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * RoleInfo id.
     * @member {number} id
     * @memberof RoleInfo
     * @instance
     */
    RoleInfo.prototype.id = 0;

    /**
     * RoleInfo name.
     * @member {string} name
     * @memberof RoleInfo
     * @instance
     */
    RoleInfo.prototype.name = "";

    /**
     * RoleInfo luckyValue.
     * @member {number} luckyValue
     * @memberof RoleInfo
     * @instance
     */
    RoleInfo.prototype.luckyValue = 0;

    /**
     * RoleInfo moodValue.
     * @member {number} moodValue
     * @memberof RoleInfo
     * @instance
     */
    RoleInfo.prototype.moodValue = 0;

    /**
     * RoleInfo money.
     * @member {number} money
     * @memberof RoleInfo
     * @instance
     */
    RoleInfo.prototype.money = 0;

    /**
     * RoleInfo eventFinishedData.
     * @member {Object.<string,number>} eventFinishedData
     * @memberof RoleInfo
     * @instance
     */
    RoleInfo.prototype.eventFinishedData = $util.emptyObject;

    /**
     * Creates a new RoleInfo instance using the specified properties.
     * @function create
     * @memberof RoleInfo
     * @static
     * @param {IRoleInfo=} [properties] Properties to set
     * @returns {RoleInfo} RoleInfo instance
     */
    RoleInfo.create = function create(properties) {
        return new RoleInfo(properties);
    };

    /**
     * Encodes the specified RoleInfo message. Does not implicitly {@link RoleInfo.verify|verify} messages.
     * @function encode
     * @memberof RoleInfo
     * @static
     * @param {IRoleInfo} message RoleInfo message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    RoleInfo.encode = function encode(message, writer) {
        if (!writer)
            writer = $Writer.create();
        if (message.id != null && message.hasOwnProperty("id"))
            writer.uint32(/* id 1, wireType 0 =*/8).int32(message.id);
        if (message.name != null && message.hasOwnProperty("name"))
            writer.uint32(/* id 2, wireType 2 =*/18).string(message.name);
        if (message.luckyValue != null && message.hasOwnProperty("luckyValue"))
            writer.uint32(/* id 3, wireType 0 =*/24).int32(message.luckyValue);
        if (message.moodValue != null && message.hasOwnProperty("moodValue"))
            writer.uint32(/* id 4, wireType 0 =*/32).int32(message.moodValue);
        if (message.money != null && message.hasOwnProperty("money"))
            writer.uint32(/* id 5, wireType 0 =*/40).int32(message.money);
        if (message.eventFinishedData != null && message.hasOwnProperty("eventFinishedData"))
            for (var keys = Object.keys(message.eventFinishedData), i = 0; i < keys.length; ++i)
                writer.uint32(/* id 6, wireType 2 =*/50).fork().uint32(/* id 1, wireType 0 =*/8).int32(keys[i]).uint32(/* id 2, wireType 0 =*/16).int32(message.eventFinishedData[keys[i]]).ldelim();
        return writer;
    };

    /**
     * Encodes the specified RoleInfo message, length delimited. Does not implicitly {@link RoleInfo.verify|verify} messages.
     * @function encodeDelimited
     * @memberof RoleInfo
     * @static
     * @param {IRoleInfo} message RoleInfo message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    RoleInfo.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a RoleInfo message from the specified reader or buffer.
     * @function decode
     * @memberof RoleInfo
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {RoleInfo} RoleInfo
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    RoleInfo.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.RoleInfo(), key;
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
                message.luckyValue = reader.int32();
                break;
            case 4:
                message.moodValue = reader.int32();
                break;
            case 5:
                message.money = reader.int32();
                break;
            case 6:
                reader.skip().pos++;
                if (message.eventFinishedData === $util.emptyObject)
                    message.eventFinishedData = {};
                key = reader.int32();
                reader.pos++;
                message.eventFinishedData[key] = reader.int32();
                break;
            default:
                reader.skipType(tag & 7);
                break;
            }
        }
        return message;
    };

    /**
     * Decodes a RoleInfo message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof RoleInfo
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {RoleInfo} RoleInfo
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    RoleInfo.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a RoleInfo message.
     * @function verify
     * @memberof RoleInfo
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    RoleInfo.verify = function verify(message) {
        if (typeof message !== "object" || message === null)
            return "object expected";
        if (message.id != null && message.hasOwnProperty("id"))
            if (!$util.isInteger(message.id))
                return "id: integer expected";
        if (message.name != null && message.hasOwnProperty("name"))
            if (!$util.isString(message.name))
                return "name: string expected";
        if (message.luckyValue != null && message.hasOwnProperty("luckyValue"))
            if (!$util.isInteger(message.luckyValue))
                return "luckyValue: integer expected";
        if (message.moodValue != null && message.hasOwnProperty("moodValue"))
            if (!$util.isInteger(message.moodValue))
                return "moodValue: integer expected";
        if (message.money != null && message.hasOwnProperty("money"))
            if (!$util.isInteger(message.money))
                return "money: integer expected";
        if (message.eventFinishedData != null && message.hasOwnProperty("eventFinishedData")) {
            if (!$util.isObject(message.eventFinishedData))
                return "eventFinishedData: object expected";
            var key = Object.keys(message.eventFinishedData);
            for (var i = 0; i < key.length; ++i) {
                if (!$util.key32Re.test(key[i]))
                    return "eventFinishedData: integer key{k:int32} expected";
                if (!$util.isInteger(message.eventFinishedData[key[i]]))
                    return "eventFinishedData: integer{k:int32} expected";
            }
        }
        return null;
    };

    /**
     * Creates a RoleInfo message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof RoleInfo
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {RoleInfo} RoleInfo
     */
    RoleInfo.fromObject = function fromObject(object) {
        if (object instanceof $root.RoleInfo)
            return object;
        var message = new $root.RoleInfo();
        if (object.id != null)
            message.id = object.id | 0;
        if (object.name != null)
            message.name = String(object.name);
        if (object.luckyValue != null)
            message.luckyValue = object.luckyValue | 0;
        if (object.moodValue != null)
            message.moodValue = object.moodValue | 0;
        if (object.money != null)
            message.money = object.money | 0;
        if (object.eventFinishedData) {
            if (typeof object.eventFinishedData !== "object")
                throw TypeError(".RoleInfo.eventFinishedData: object expected");
            message.eventFinishedData = {};
            for (var keys = Object.keys(object.eventFinishedData), i = 0; i < keys.length; ++i)
                message.eventFinishedData[keys[i]] = object.eventFinishedData[keys[i]] | 0;
        }
        return message;
    };

    /**
     * Creates a plain object from a RoleInfo message. Also converts values to other types if specified.
     * @function toObject
     * @memberof RoleInfo
     * @static
     * @param {RoleInfo} message RoleInfo
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    RoleInfo.toObject = function toObject(message, options) {
        if (!options)
            options = {};
        var object = {};
        if (options.objects || options.defaults)
            object.eventFinishedData = {};
        if (options.defaults) {
            object.id = 0;
            object.name = "";
            object.luckyValue = 0;
            object.moodValue = 0;
            object.money = 0;
        }
        if (message.id != null && message.hasOwnProperty("id"))
            object.id = message.id;
        if (message.name != null && message.hasOwnProperty("name"))
            object.name = message.name;
        if (message.luckyValue != null && message.hasOwnProperty("luckyValue"))
            object.luckyValue = message.luckyValue;
        if (message.moodValue != null && message.hasOwnProperty("moodValue"))
            object.moodValue = message.moodValue;
        if (message.money != null && message.hasOwnProperty("money"))
            object.money = message.money;
        var keys2;
        if (message.eventFinishedData && (keys2 = Object.keys(message.eventFinishedData)).length) {
            object.eventFinishedData = {};
            for (var j = 0; j < keys2.length; ++j)
                object.eventFinishedData[keys2[j]] = message.eventFinishedData[keys2[j]];
        }
        return object;
    };

    /**
     * Converts this RoleInfo to JSON.
     * @function toJSON
     * @memberof RoleInfo
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    RoleInfo.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    return RoleInfo;
})();

$root.WeatherInfo = (function() {

    /**
     * Properties of a WeatherInfo.
     * @exports IWeatherInfo
     * @interface IWeatherInfo
     * @property {number|null} [id] WeatherInfo id
     */

    /**
     * Constructs a new WeatherInfo.
     * @exports WeatherInfo
     * @classdesc Represents a WeatherInfo.
     * @implements IWeatherInfo
     * @constructor
     * @param {IWeatherInfo=} [properties] Properties to set
     */
    function WeatherInfo(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * WeatherInfo id.
     * @member {number} id
     * @memberof WeatherInfo
     * @instance
     */
    WeatherInfo.prototype.id = 0;

    /**
     * Creates a new WeatherInfo instance using the specified properties.
     * @function create
     * @memberof WeatherInfo
     * @static
     * @param {IWeatherInfo=} [properties] Properties to set
     * @returns {WeatherInfo} WeatherInfo instance
     */
    WeatherInfo.create = function create(properties) {
        return new WeatherInfo(properties);
    };

    /**
     * Encodes the specified WeatherInfo message. Does not implicitly {@link WeatherInfo.verify|verify} messages.
     * @function encode
     * @memberof WeatherInfo
     * @static
     * @param {IWeatherInfo} message WeatherInfo message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    WeatherInfo.encode = function encode(message, writer) {
        if (!writer)
            writer = $Writer.create();
        if (message.id != null && message.hasOwnProperty("id"))
            writer.uint32(/* id 1, wireType 0 =*/8).int32(message.id);
        return writer;
    };

    /**
     * Encodes the specified WeatherInfo message, length delimited. Does not implicitly {@link WeatherInfo.verify|verify} messages.
     * @function encodeDelimited
     * @memberof WeatherInfo
     * @static
     * @param {IWeatherInfo} message WeatherInfo message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    WeatherInfo.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a WeatherInfo message from the specified reader or buffer.
     * @function decode
     * @memberof WeatherInfo
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {WeatherInfo} WeatherInfo
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    WeatherInfo.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.WeatherInfo();
        while (reader.pos < end) {
            var tag = reader.uint32();
            switch (tag >>> 3) {
            case 1:
                message.id = reader.int32();
                break;
            default:
                reader.skipType(tag & 7);
                break;
            }
        }
        return message;
    };

    /**
     * Decodes a WeatherInfo message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof WeatherInfo
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {WeatherInfo} WeatherInfo
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    WeatherInfo.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a WeatherInfo message.
     * @function verify
     * @memberof WeatherInfo
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    WeatherInfo.verify = function verify(message) {
        if (typeof message !== "object" || message === null)
            return "object expected";
        if (message.id != null && message.hasOwnProperty("id"))
            if (!$util.isInteger(message.id))
                return "id: integer expected";
        return null;
    };

    /**
     * Creates a WeatherInfo message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof WeatherInfo
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {WeatherInfo} WeatherInfo
     */
    WeatherInfo.fromObject = function fromObject(object) {
        if (object instanceof $root.WeatherInfo)
            return object;
        var message = new $root.WeatherInfo();
        if (object.id != null)
            message.id = object.id | 0;
        return message;
    };

    /**
     * Creates a plain object from a WeatherInfo message. Also converts values to other types if specified.
     * @function toObject
     * @memberof WeatherInfo
     * @static
     * @param {WeatherInfo} message WeatherInfo
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    WeatherInfo.toObject = function toObject(message, options) {
        if (!options)
            options = {};
        var object = {};
        if (options.defaults)
            object.id = 0;
        if (message.id != null && message.hasOwnProperty("id"))
            object.id = message.id;
        return object;
    };

    /**
     * Converts this WeatherInfo to JSON.
     * @function toJSON
     * @memberof WeatherInfo
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    WeatherInfo.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    return WeatherInfo;
})();

module.exports = $root;
