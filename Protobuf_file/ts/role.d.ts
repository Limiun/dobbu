import * as $protobuf from "protobufjs";

/** Properties of a UserMsg. */
export interface IUserMsg {

    /** UserMsg id */
    id?: (number|null);

    /** UserMsg name */
    name?: (string|null);

    /** UserMsg age */
    age?: (number|null);

    /** UserMsg state */
    state?: (number|null);
}

/** Represents a UserMsg. */
export class UserMsg implements IUserMsg {

    /**
     * Constructs a new UserMsg.
     * @param [properties] Properties to set
     */
    constructor(properties?: IUserMsg);

    /** UserMsg id. */
    public id: number;

    /** UserMsg name. */
    public name: string;

    /** UserMsg age. */
    public age: number;

    /** UserMsg state. */
    public state: number;

    /**
     * Creates a new UserMsg instance using the specified properties.
     * @param [properties] Properties to set
     * @returns UserMsg instance
     */
    public static create(properties?: IUserMsg): UserMsg;

    /**
     * Encodes the specified UserMsg message. Does not implicitly {@link UserMsg.verify|verify} messages.
     * @param message UserMsg message or plain object to encode
     * @param [writer] Writer to encode to
     * @returns Writer
     */
    public static encode(message: IUserMsg, writer?: $protobuf.Writer): $protobuf.Writer;

    /**
     * Encodes the specified UserMsg message, length delimited. Does not implicitly {@link UserMsg.verify|verify} messages.
     * @param message UserMsg message or plain object to encode
     * @param [writer] Writer to encode to
     * @returns Writer
     */
    public static encodeDelimited(message: IUserMsg, writer?: $protobuf.Writer): $protobuf.Writer;

    /**
     * Decodes a UserMsg message from the specified reader or buffer.
     * @param reader Reader or buffer to decode from
     * @param [length] Message length if known beforehand
     * @returns UserMsg
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    public static decode(reader: ($protobuf.Reader|Uint8Array), length?: number): UserMsg;

    /**
     * Decodes a UserMsg message from the specified reader or buffer, length delimited.
     * @param reader Reader or buffer to decode from
     * @returns UserMsg
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    public static decodeDelimited(reader: ($protobuf.Reader|Uint8Array)): UserMsg;

    /**
     * Verifies a UserMsg message.
     * @param message Plain object to verify
     * @returns `null` if valid, otherwise the reason why it is not
     */
    public static verify(message: { [k: string]: any }): (string|null);

    /**
     * Creates a UserMsg message from a plain object. Also converts values to their respective internal types.
     * @param object Plain object
     * @returns UserMsg
     */
    public static fromObject(object: { [k: string]: any }): UserMsg;

    /**
     * Creates a plain object from a UserMsg message. Also converts values to other types if specified.
     * @param message UserMsg
     * @param [options] Conversion options
     * @returns Plain object
     */
    public static toObject(message: UserMsg, options?: $protobuf.IConversionOptions): { [k: string]: any };

    /**
     * Converts this UserMsg to JSON.
     * @returns JSON object
     */
    public toJSON(): { [k: string]: any };
}
