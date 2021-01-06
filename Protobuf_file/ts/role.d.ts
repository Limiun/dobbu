import * as $protobuf from "protobufjs";

/** Properties of a Response. */
export interface IResponse {

    /** Response status */
    status?: (number|null);

    /** Response msg */
    msg?: (string|null);
}

/** Represents a Response. */
export class Response implements IResponse {

    /**
     * Constructs a new Response.
     * @param [properties] Properties to set
     */
    constructor(properties?: IResponse);

    /** Response status. */
    public status: number;

    /** Response msg. */
    public msg: string;

    /**
     * Creates a new Response instance using the specified properties.
     * @param [properties] Properties to set
     * @returns Response instance
     */
    public static create(properties?: IResponse): Response;

    /**
     * Encodes the specified Response message. Does not implicitly {@link Response.verify|verify} messages.
     * @param message Response message or plain object to encode
     * @param [writer] Writer to encode to
     * @returns Writer
     */
    public static encode(message: IResponse, writer?: $protobuf.Writer): $protobuf.Writer;

    /**
     * Encodes the specified Response message, length delimited. Does not implicitly {@link Response.verify|verify} messages.
     * @param message Response message or plain object to encode
     * @param [writer] Writer to encode to
     * @returns Writer
     */
    public static encodeDelimited(message: IResponse, writer?: $protobuf.Writer): $protobuf.Writer;

    /**
     * Decodes a Response message from the specified reader or buffer.
     * @param reader Reader or buffer to decode from
     * @param [length] Message length if known beforehand
     * @returns Response
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    public static decode(reader: ($protobuf.Reader|Uint8Array), length?: number): Response;

    /**
     * Decodes a Response message from the specified reader or buffer, length delimited.
     * @param reader Reader or buffer to decode from
     * @returns Response
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    public static decodeDelimited(reader: ($protobuf.Reader|Uint8Array)): Response;

    /**
     * Verifies a Response message.
     * @param message Plain object to verify
     * @returns `null` if valid, otherwise the reason why it is not
     */
    public static verify(message: { [k: string]: any }): (string|null);

    /**
     * Creates a Response message from a plain object. Also converts values to their respective internal types.
     * @param object Plain object
     * @returns Response
     */
    public static fromObject(object: { [k: string]: any }): Response;

    /**
     * Creates a plain object from a Response message. Also converts values to other types if specified.
     * @param message Response
     * @param [options] Conversion options
     * @returns Plain object
     */
    public static toObject(message: Response, options?: $protobuf.IConversionOptions): { [k: string]: any };

    /**
     * Converts this Response to JSON.
     * @returns JSON object
     */
    public toJSON(): { [k: string]: any };
}

/** Properties of a Request. */
export interface IRequest {

    /** Request uid */
    uid?: (number|null);

    /** Request token */
    token?: (string|null);
}

/** Represents a Request. */
export class Request implements IRequest {

    /**
     * Constructs a new Request.
     * @param [properties] Properties to set
     */
    constructor(properties?: IRequest);

    /** Request uid. */
    public uid: number;

    /** Request token. */
    public token: string;

    /**
     * Creates a new Request instance using the specified properties.
     * @param [properties] Properties to set
     * @returns Request instance
     */
    public static create(properties?: IRequest): Request;

    /**
     * Encodes the specified Request message. Does not implicitly {@link Request.verify|verify} messages.
     * @param message Request message or plain object to encode
     * @param [writer] Writer to encode to
     * @returns Writer
     */
    public static encode(message: IRequest, writer?: $protobuf.Writer): $protobuf.Writer;

    /**
     * Encodes the specified Request message, length delimited. Does not implicitly {@link Request.verify|verify} messages.
     * @param message Request message or plain object to encode
     * @param [writer] Writer to encode to
     * @returns Writer
     */
    public static encodeDelimited(message: IRequest, writer?: $protobuf.Writer): $protobuf.Writer;

    /**
     * Decodes a Request message from the specified reader or buffer.
     * @param reader Reader or buffer to decode from
     * @param [length] Message length if known beforehand
     * @returns Request
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    public static decode(reader: ($protobuf.Reader|Uint8Array), length?: number): Request;

    /**
     * Decodes a Request message from the specified reader or buffer, length delimited.
     * @param reader Reader or buffer to decode from
     * @returns Request
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    public static decodeDelimited(reader: ($protobuf.Reader|Uint8Array)): Request;

    /**
     * Verifies a Request message.
     * @param message Plain object to verify
     * @returns `null` if valid, otherwise the reason why it is not
     */
    public static verify(message: { [k: string]: any }): (string|null);

    /**
     * Creates a Request message from a plain object. Also converts values to their respective internal types.
     * @param object Plain object
     * @returns Request
     */
    public static fromObject(object: { [k: string]: any }): Request;

    /**
     * Creates a plain object from a Request message. Also converts values to other types if specified.
     * @param message Request
     * @param [options] Conversion options
     * @returns Plain object
     */
    public static toObject(message: Request, options?: $protobuf.IConversionOptions): { [k: string]: any };

    /**
     * Converts this Request to JSON.
     * @returns JSON object
     */
    public toJSON(): { [k: string]: any };
}

/** Properties of a UserMsg1. */
export interface IUserMsg1 {

    /** UserMsg1 id1 */
    id1?: (number|null);

    /** UserMsg1 name1 */
    name1?: (string|null);

    /** UserMsg1 age1 */
    age1?: (number|null);

    /** UserMsg1 state1 */
    state1?: (number|null);
}

/** Represents a UserMsg1. */
export class UserMsg1 implements IUserMsg1 {

    /**
     * Constructs a new UserMsg1.
     * @param [properties] Properties to set
     */
    constructor(properties?: IUserMsg1);

    /** UserMsg1 id1. */
    public id1: number;

    /** UserMsg1 name1. */
    public name1: string;

    /** UserMsg1 age1. */
    public age1: number;

    /** UserMsg1 state1. */
    public state1: number;

    /**
     * Creates a new UserMsg1 instance using the specified properties.
     * @param [properties] Properties to set
     * @returns UserMsg1 instance
     */
    public static create(properties?: IUserMsg1): UserMsg1;

    /**
     * Encodes the specified UserMsg1 message. Does not implicitly {@link UserMsg1.verify|verify} messages.
     * @param message UserMsg1 message or plain object to encode
     * @param [writer] Writer to encode to
     * @returns Writer
     */
    public static encode(message: IUserMsg1, writer?: $protobuf.Writer): $protobuf.Writer;

    /**
     * Encodes the specified UserMsg1 message, length delimited. Does not implicitly {@link UserMsg1.verify|verify} messages.
     * @param message UserMsg1 message or plain object to encode
     * @param [writer] Writer to encode to
     * @returns Writer
     */
    public static encodeDelimited(message: IUserMsg1, writer?: $protobuf.Writer): $protobuf.Writer;

    /**
     * Decodes a UserMsg1 message from the specified reader or buffer.
     * @param reader Reader or buffer to decode from
     * @param [length] Message length if known beforehand
     * @returns UserMsg1
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    public static decode(reader: ($protobuf.Reader|Uint8Array), length?: number): UserMsg1;

    /**
     * Decodes a UserMsg1 message from the specified reader or buffer, length delimited.
     * @param reader Reader or buffer to decode from
     * @returns UserMsg1
     * @throws {Error} If the payload is not a reader or valid buffer
     * @throws {$protobuf.util.ProtocolError} If required fields are missing
     */
    public static decodeDelimited(reader: ($protobuf.Reader|Uint8Array)): UserMsg1;

    /**
     * Verifies a UserMsg1 message.
     * @param message Plain object to verify
     * @returns `null` if valid, otherwise the reason why it is not
     */
    public static verify(message: { [k: string]: any }): (string|null);

    /**
     * Creates a UserMsg1 message from a plain object. Also converts values to their respective internal types.
     * @param object Plain object
     * @returns UserMsg1
     */
    public static fromObject(object: { [k: string]: any }): UserMsg1;

    /**
     * Creates a plain object from a UserMsg1 message. Also converts values to other types if specified.
     * @param message UserMsg1
     * @param [options] Conversion options
     * @returns Plain object
     */
    public static toObject(message: UserMsg1, options?: $protobuf.IConversionOptions): { [k: string]: any };

    /**
     * Converts this UserMsg1 to JSON.
     * @returns JSON object
     */
    public toJSON(): { [k: string]: any };
}
