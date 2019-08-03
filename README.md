Idea Plugin Get VirtualFile Content by Path Demo
================================================

Run plugin in IDEA
------------------

```
./gradlew runIde
```

Open "Sample Action", and input file path like `xxx.iml` or `src/some.txt` to content.

Build the plugin to a zip
-------------------------

```
./gradlew buildPlugin
```

It will generate the plugin file in `./build/distributions`

Notice
-------

- Use `version 'IC-2018.1.5'` every time to reduce download. (about 500M)
- Don't forget to change `id` and `name` in `resources/META-INF/plugin.xml` to current project
- `updateSinceUntilBuild`默认为`false`，会把插件的适用范围限制在当前版本之前，不能在新版本上使用，很烦人，所以设为`false`
