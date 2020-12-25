/*eslint-disable block-scoped-var, no-redeclare, no-control-regex, no-prototype-builtins*/
"use strict";

//var $protobuf = require("protobufjs/minimal");
var $protobuf = protobuf;
// Common aliases
var $Reader = $protobuf.Reader, $Writer = $protobuf.Writer, $util = $protobuf.util;

// Exported root namespace
var $root = $protobuf.roots["default"] || ($protobuf.roots["default"] = {});

$root.test1Msg = (function() {

    /**
     * Properties of a test1Msg.
     * @exports Itest1Msg
     * @interface Itest1Msg
     * @property {number|null} [id] test1Msg id
     * @property {string|null} [name] test1Msg name
     * @property {number|null} [age] test1Msg age
     * @property {number|null} [state] test1Msg state
     */

    /**
     * Constructs a new test1Msg.
     * @exports test1Msg
     * @classdesc Represents a test1Msg.
     * @implements Itest1Msg
     * @constructor
     * @param {Itest1Msg=} [properties] Properties to set
     */
    function test1Msg(properties) {
        if (properties)
            for (var keys = Object.keys(properties), i = 0; i < keys.length; ++i)
                if (properties[keys[i]] != null)
                    this[keys[i]] = properties[keys[i]];
    }

    /**
     * test1Msg id.
     * @member {number} id
     * @memberof test1Msg
     * @instance
     */
    test1Msg.prototype.id = 0;

    /**
     * test1Msg name.
     * @member {string} name
     * @memberof test1Msg
     * @instance
     */
    test1Msg.prototype.name = "";

    /**
     * test1Msg age.
     * @member {number} age
     * @memberof test1Msg
     * @instance
     */
    test1Msg.prototype.age = 0;

    /**
     * test1Msg state.
     * @member {number} state
     * @memberof test1Msg
     * @instance
     */
    test1Msg.prototype.state = 0;

    /**
     * Creates a new test1Msg instance using the specified properties.
     * @function create
     * @memberof test1Msg
     * @static
     * @param {Itest1Msg=} [properties] Properties to set
     * @returns {test1Msg} test1Msg instance
     */
    test1Msg.create = function create(properties) {
        return new test1Msg(properties);
    };

    /**
     * Encodes the specified test1Msg message. Does not implicitly {@link test1Msg.verify|verify} messages.
     * @function encode
     * @memberof test1Msg
     * @static
     * @param {Itest1Msg} message test1Msg message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    test1Msg.encode = function encode(message, writer) {
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
     * Encodes the specified test1Msg message, length delimited. Does not implicitly {@link test1Msg.verify|verify} messages.
     * @function encodeDelimited
     * @memberof test1Msg
     * @static
     * @param {Itest1Msg} message test1Msg message or plain object to encode
     * @param {$protobuf.Writer} [writer] Writer to encode to
     * @returns {$protobuf.Writer} Writer
     */
    test1Msg.encodeDelimited = function encodeDelimited(message, writer) {
        return this.encode(message, writer).ldelim();
    };

    /**
     * Decodes a test1Msg message from the specified reader or buffer.
     * @function decode
     * @memberof test1Msg
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @param {number} [length] Message length if known beforehand
     * @returns {test1Msg} test1Msg
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    test1Msg.decode = function decode(reader, length) {
        if (!(reader instanceof $Reader))
            reader = $Reader.create(reader);
        var end = length === undefined ? reader.len : reader.pos + length, message = new $root.test1Msg();
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
     * Decodes a test1Msg message from the specified reader or buffer, length delimited.
     * @function decodeDelimited
     * @memberof test1Msg
     * @static
     * @param {$protobuf.Reader|Uint8Array} reader Reader or buffer to decode from
     * @returns {test1Msg} test1Msg
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    test1Msg.decodeDelimited = function decodeDelimited(reader) {
        if (!(reader instanceof $Reader))
            reader = new $Reader(reader);
        return this.decode(reader, reader.uint32());
    };

    /**
     * Verifies a test1Msg message.
     * @function verify
     * @memberof test1Msg
     * @static
     * @param {Object.<string,*>} message Plain object to verify
     * @returns {string|null} `null` if valid, otherwise the reason why it is not
     */
    test1Msg.verify = function verify(message) {
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
     * Creates a test1Msg message from a plain object. Also converts values to their respective internal types.
     * @function fromObject
     * @memberof test1Msg
     * @static
     * @param {Object.<string,*>} object Plain object
     * @returns {test1Msg} test1Msg
     */
    test1Msg.fromObject = function fromObject(object) {
        if (object instanceof $root.test1Msg)
            return object;
        var message = new $root.test1Msg();
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
     * Creates a plain object from a test1Msg message. Also converts values to other types if specified.
     * @function toObject
     * @memberof test1Msg
     * @static
     * @param {test1Msg} message test1Msg
     * @param {$protobuf.IConversionOptions} [options] Conversion options
     * @returns {Object.<string,*>} Plain object
     */
    test1Msg.toObject = function toObject(message, options) {
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
     * Converts this test1Msg to JSON.
     * @function toJSON
     * @memberof test1Msg
     * @instance
     * @returns {Object.<string,*>} JSON object
     */
    test1Msg.prototype.toJSON = function toJSON() {
        return this.constructor.toObject(this, $protobuf.util.toJSONOptions);
    };

    return test1Msg;
})();

//module.exports  = $root;
