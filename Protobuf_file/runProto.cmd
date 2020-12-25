::生成java的protobuf消息
set "protobuf_path_java=F:\Protobuf_file\java\" 
set "proto_path=F:\Protobuf_file\"
set "protobuf_path_js=F:\Protobuf_file\js\"
set "protobuf_path_ts=F:\Protobuf_file\ts\"

::移除原有的java和js文件
rmdir /s/q %protobuf_path_java%
rmdir /s/q %protobuf_path_js%
md %protobuf_path_java%
md %protobuf_path_js%

::创建java的protobuf文件
for %%f in (*.proto) do protoc.exe --proto_path=./ --java_out=%protobuf_path_java% %%f
::for %%f in (*.proto) do protoc.exe --proto_path=%proto_path% --js_out=import_style=commonjs,binary:. %protobuf_path_js% %%f

::创建js的protobuf（这里js暂时全部放到一个文件里，proto.js，没有分开放）
for %%f in (*.proto) do pbjs -t static-module -w commonjs -o F:\Protobuf_file\js\role.js %%f


::将proto.js文件 转为 proto.d.t文件
::pbts -o proto.d.ts F:\Protobuf_file\js\proto.js
