/*eslint-disable block-scoped-var, no-redeclare, no-control-regex, no-prototype-builtins*/
"use strict";

var $protobuf = require("protobufjs/minimal");

// Common aliases
var $Reader = $protobuf.Reader, $Writer = $protobuf.Writer, $util = $protobuf.util;

// Exported root namespace
var $root = $protobuf.roots["default"] || ($protobuf.roots["default"] = {});

$root.UserMsg = (function() {

    /**
     * Properties of a UserMsg.
     * @exports IUserMsg
     * @interface IUserMsg
     * @property {number|null} [id] UserMsg id
     * @property {string|null} [name] UserMsg name
     * @property {number|null} [age] UserMsg age
     * @property {number|null} [state] UserMsg state
     */

    /**
     * Constructs a new UserMsg.
     * @exports UserMsg
     * @classdesc Represents a UserMsg.
     * @implements IUserMsg
     * @constructor
     * @param {IUserMsg=} [properties] Properties to set
     */
    function UserMsg(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * UserMsg id.
     * @member {number} id
     * @memberof UserMsg
     * @instance
     */
    UserMsg.prototype.id = 0;

    /**
     * UserMsg name.
     * @member {string} name
     * @memberof UserMsg
     * @instance
     */
    UserMsg.prototype.name = "";

    /**
     * UserMsg age.
     * @member {number} age
     * @memberof UserMsg
     * @instance
     */
    UserMsg.prototype.age = 0;

    /**
     * UserMsg state.
     * @member {number} state
     * @memberof UserMsg
     * @instance
     */
    UserMsg.prototype.state = 0;

    /**
     * Creates a new UserMsg instance using the specified properties.
     * @function create
     * @memberof UserMsg
     * @static
     * @param {IUserMsg=} [properties] Properties to set
     * @returns {UserMsg} UserMsg instance
     */
    UserMsg.create = function create(properties) {
        return new UserMsg(properties);
    };

    /**
     * Encodes the specified UserMsg message. Does not implicitly {@link UserMsg.verify|verify} messages.
     * @function encode
     * @memberof UserMsg
     * @static
     * @param {IUserMsg} message UserMsg message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    UserMsg.encode = function encode(message, writer) {
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
     * Encodes the specified UserMsg message, length delimited. Does not implicitly {@link UserMsg.verify|verify} messages.
     * @function encodeDelimited
     * @memberof UserMsg
     * @static
     * @param {IUserMsg} message UserMsg message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    UserMsg.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a UserMsg message from the specified reader or buffer.
     * @function decode
     * @memberof UserMsg
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {UserMsg} UserMsg
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    UserMsg.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.UserMsg();
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
     * Decodes a UserMsg message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof UserMsg
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {UserMsg} UserMsg
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    UserMsg.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a UserMsg message.
     * @function verify
     * @memberof UserMsg
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    UserMsg.verify = function verify(message) {
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
     * Creates a UserMsg message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof UserMsg
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {UserMsg} UserMsg
     */
    UserMsg.fromObject = function fromObject(object) {
        if (object instanceof $root.UserMsg)
            return object;
        var message = new $root.UserMsg();
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
     * Creates a plain object from a UserMsg message. Also converts values to other types if specified.
     * @function toObject
     * @memberof UserMsg
     * @static
     * @param {UserMsg} message UserMsg
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    UserMsg.toObject = function toObject(message, options) {
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
     * Converts this UserMsg to JSON.
     * @function toJSON
     * @memberof UserMsg
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    UserMsg.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    return UserMsg;
})();

$root.UserMsg1 = (function() {

    /**
     * Properties of a UserMsg1.
     * @exports IUserMsg1
     * @interface IUserMsg1
     * @property {number|null} [id1] UserMsg1 id1
     * @property {string|null} [name1] UserMsg1 name1
     * @property {number|null} [age1] UserMsg1 age1
     * @property {number|null} [state1] UserMsg1 state1
     */

    /**
     * Constructs a new UserMsg1.
     * @exports UserMsg1
     * @classdesc Represents a UserMsg1.
     * @implements IUserMsg1
     * @constructor
     * @param {IUserMsg1=} [properties] Properties to set
     */
    function UserMsg1(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * UserMsg1 id1.
     * @member {number} id1
     * @memberof UserMsg1
     * @instance
     */
    UserMsg1.prototype.id1 = 0;

    /**
     * UserMsg1 name1.
     * @member {string} name1
     * @memberof UserMsg1
     * @instance
     */
    UserMsg1.prototype.name1 = "";

    /**
     * UserMsg1 age1.
     * @member {number} age1
     * @memberof UserMsg1
     * @instance
     */
    UserMsg1.prototype.age1 = 0;

    /**
     * UserMsg1 state1.
     * @member {number} state1
     * @memberof UserMsg1
     * @instance
     */
    UserMsg1.prototype.state1 = 0;

    /**
     * Creates a new UserMsg1 instance using the specified properties.
     * @function create
     * @memberof UserMsg1
     * @static
     * @param {IUserMsg1=} [properties] Properties to set
     * @returns {UserMsg1} UserMsg1 instance
     */
    UserMsg1.create = function create(properties) {
        return new UserMsg1(properties);
    };

    /**
     * Encodes the specified UserMsg1 message. Does not implicitly {@link UserMsg1.verify|verify} messages.
     * @function encode
     * @memberof UserMsg1
     * @static
     * @param {IUserMsg1} message UserMsg1 message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    UserMsg1.encode = function encode(message, writer) {
        if (!writer)
            writer = $Writer.create();
        if (message.id1 != null && message.hasOwnProperty("id1"))
            writer.uint32(/* id 1, wireType 0 =*/8).int32(message.id1);
        if (message.name1 != null && message.hasOwnProperty("name1"))
            writer.uint32(/* id 2, wireType 2 =*/18).string(message.name1);
        if (message.age1 != null && message.hasOwnProperty("age1"))
            writer.uint32(/* id 3, wireType 0 =*/24).int32(message.age1);
        if (message.state1 != null && message.hasOwnProperty("state1"))
            writer.uint32(/* id 4, wireType 0 =*/32).int32(message.state1);
        return writer;
    };

    /**
     * Encodes the specified UserMsg1 message, length delimited. Does not implicitly {@link UserMsg1.verify|verify} messages.
     * @function encodeDelimited
     * @memberof UserMsg1
     * @static
     * @param {IUserMsg1} message UserMsg1 message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    UserMsg1.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a UserMsg1 message from the specified reader or buffer.
     * @function decode
     * @memberof UserMsg1
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {UserMsg1} UserMsg1
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    UserMsg1.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.UserMsg1();
        while (reader.pos < end) {
            var tag = reader.uint32();
            switch (tag >>> 3) {
            case 1:
                message.id1 = reader.int32();
                break;
            case 2:
                message.name1 = reader.string();
                break;
            case 3:
                message.age1 = reader.int32();
                break;
            case 4:
                message.state1 = reader.int32();
                break;
            default:
                reader.skipType(tag & 7);
                break;
            }
        }
        return message;
    };

    /**
     * Decodes a UserMsg1 message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof UserMsg1
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {UserMsg1} UserMsg1
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    UserMsg1.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a UserMsg1 message.
     * @function verify
     * @memberof UserMsg1
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    UserMsg1.verify = function verify(message) {
        if (typeof message !== "object" || message === null)
            return "object expected";
        if (message.id1 != null && message.hasOwnProperty("id1"))
            if (!$util.isInteger(message.id1))
                return "id1: integer expected";
        if (message.name1 != null && message.hasOwnProperty("name1"))
            if (!$util.isString(message.name1))
                return "name1: string expected";
        if (message.age1 != null && message.hasOwnProperty("age1"))
            if (!$util.isInteger(message.age1))
                return "age1: integer expected";
        if (message.state1 != null && message.hasOwnProperty("state1"))
            if (!$util.isInteger(message.state1))
                return "state1: integer expected";
        return null;
    };

    /**
     * Creates a UserMsg1 message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof UserMsg1
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {UserMsg1} UserMsg1
     */
    UserMsg1.fromObject = function fromObject(object) {
        if (object instanceof $root.UserMsg1)
            return object;
        var message = new $root.UserMsg1();
        if (object.id1 != null)
            message.id1 = object.id1 | 0;
        if (object.name1 != null)
            message.name1 = String(object.name1);
        if (object.age1 != null)
            message.age1 = object.age1 | 0;
        if (object.state1 != null)
            message.state1 = object.state1 | 0;
        return message;
    };

    /**
     * Creates a plain object from a UserMsg1 message. Also converts values to other types if specified.
     * @function toObject
     * @memberof UserMsg1
     * @static
     * @param {UserMsg1} message UserMsg1
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    UserMsg1.toObject = function toObject(message, options) {
        if (!options)
            options = {};
        var object = {};
        if (options.defaults) {
            object.id1 = 0;
            object.name1 = "";
            object.age1 = 0;
            object.state1 = 0;
        }
        if (message.id1 != null && message.hasOwnProperty("id1"))
            object.id1 = message.id1;
        if (message.name1 != null && message.hasOwnProperty("name1"))
            object.name1 = message.name1;
        if (message.age1 != null && message.hasOwnProperty("age1"))
            object.age1 = message.age1;
        if (message.state1 != null && message.hasOwnProperty("state1"))
            object.state1 = message.state1;
        return object;
    };

    /**
     * Converts this UserMsg1 to JSON.
     * @function toJSON
     * @memberof UserMsg1
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    UserMsg1.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    return UserMsg1;
})();

module.exports = $root;
