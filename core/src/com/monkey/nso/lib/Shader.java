package com.monkey.nso.lib;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public final class Shader {
   private static String c = "#ifdef GL_ES\nprecision mediump float;\n#endif\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform mat4 u_projTrans;\n\nvoid main() {\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    if (color.r < 0.5 && color.g < 0.5&& color.b < 0.5){\n        color.rgb = vec3(0.3, 0.3, 0.3);\n    } else if (color.r > 0.5){\n        color.rgb = vec3(0.0, 0.0, 0.0);\n    }\n    gl_FragColor = color;\n}";
   private static String d = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform float hue;\n\n\nvec3 applyHue(vec3 rgb, float hue)\n{\n    float d = radians(hue);\n    vec3 k = vec3(0.57735);\n    float c = cos(hue);\n    return rgb * c + cross(k, rgb) * sin(d) + k * dot(k, rgb) * (1.0 - c);\n}\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    color.rgb = applyHue(color.rgb, hue);\n    gl_FragColor = color;\n}";
   private static String e = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform float hue_value;\nuniform vec3 hue_color;\n\nvec3 applyHue(vec3 rgb, float hue)\n{\n    float d = radians(hue);\n    vec3 k = vec3(0.57735);\n    float c = cos(hue);\n    return rgb * c + cross(k, rgb) * sin(d) + k * dot(k, rgb) * (1.0 - c);\n}\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    color = vec4(vec3(0.299 * color.r + 0.587 * color.g + 0.114 * color.b), color.a);\n    vec4 colorized  = vec4(hue_color,color.a);\n    color = color*colorized;\n    color.rgb = applyHue(color.rgb, hue_value);\n    gl_FragColor = color;\n}";
   private static String f = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform float hue;\n\n\nvec3 applyHue(vec3 rgb, float hue)\n{\n    float d = radians(hue);\n    vec3 k = vec3(0.57735);\n    float c = cos(hue);\n    return rgb * c + cross(k, rgb) * sin(d) + k * dot(k, rgb) * (1.0 - c);\n}\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    color = vec4(vec3(0.299 * color.r + 0.587 * color.g + 0.114 * color.b), color.a);\n    color.rgb = vec3(1, color.g, color.b);\n    color.rgb = applyHue(color.rgb, hue);\n    gl_FragColor = color;\n}";
   private static String g = "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform float brightness;\nuniform float contrast;\n\nvec3 applyContrast(vec3 color, float contrast)\n{\n    return color * contrast;\n}\n\nvec3 applyBrightness(vec3 color, float brightness)\n{\n    return color + vec3(brightness, brightness, brightness);\n}\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    vec3 vctr = applyContrast(color.rgb, contrast);\n    vec3 vbrt = applyBrightness(vctr, brightness);\n    gl_FragColor = vec4(vbrt, color.a);\n}";
   private static ShaderProgram h = null;
   private static ShaderProgram i = null;
   private static ShaderProgram j = null;
   private static ShaderProgram k = null;
   private static ShaderProgram l = null;
   private static ShaderProgram m = null;
   private static ShaderProgram n = null;
   private static ShaderProgram o = null;
   public static long a;
   public static long b;

   public static void clean() {
      a = b = System.currentTimeMillis();
      if (h != null) {
         h.dispose();
      }

      if (i != null) {
         i.dispose();
      }

      if (j != null) {
         j.dispose();
      }

      if (k != null) {
         k.dispose();
      }

      if (l != null) {
         l.dispose();
      }

      if (m != null) {
         m.dispose();
      }

      if (n != null) {
         n.dispose();
      }

      if (o != null) {
         o.dispose();
      }

      h = null;
      i = null;
      j = null;
      k = null;
      l = null;
      m = null;
      n = null;
      o = null;
   }

   public static ShaderProgram b() {
      a = System.currentTimeMillis();
      if (h == null) {
         h = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", g);
      }

      return h;
   }

   public static ShaderProgram c() {
      a = System.currentTimeMillis();
      if (i == null) {
         i = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", c);
      }

      return i;
   }

   public static ShaderProgram d() {
      a = System.currentTimeMillis();
      if (j == null) {
         j = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", d);
      }

      return j;
   }

   public static ShaderProgram e() {
      a = System.currentTimeMillis();
      if (l == null) {
         l = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", f);
      }

      return l;
   }

   public static ShaderProgram f() {
      a = System.currentTimeMillis();
      if (m == null) {
         m = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\n\nuniform mat4 u_projTrans;\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\n\nvoid main() {\n    v_color = a_color;\n    v_texCoords = a_texCoord0;\n    gl_Position = u_projTrans * a_position;\n}", "#ifdef GL_ES\nprecision mediump float;\n#endif\n\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\nuniform mat4 u_projTrans;\n\nvoid main() {\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    color = vec4(vec3(0.299 * color.r + 0.587 * color.g + 0.114 * color.b), color.a);\n    gl_FragColor = color;\n}");
      }

      return m;
   }

   public static ShaderProgram g() {
      a = System.currentTimeMillis();
      if (o == null) {
         boolean var0 = true;
         Color var1 = new Color(-1);
         o = new ShaderProgram("attribute vec4 a_position;\nattribute vec4 a_color;\nattribute vec2 a_texCoord0;\nuniform mat4 u_projTrans;\nvarying vec4 v_color;\nvarying vec2 v_texCoords;\nvarying float v_lightFix;\n\nvoid main()\n{\n   v_color = a_color;\n   v_texCoords = a_texCoord0;\n   v_color.a = pow(v_color.a * (255.0/254.0) + 0.5, 1.709);\n   v_lightFix = 1.0 + pow(v_color.a, 1.41421356);\n   gl_Position =  u_projTrans * a_position;\n}\n", "#ifdef GL_ES\n#define LOWP lowp\nprecision mediump float;\n#else\n#define LOWP\n#endif\nvarying LOWP vec4 v_color;\nvarying vec2 v_texCoords;\nuniform sampler2D u_texture;\n\nvoid main(){\n    vec4 color = texture2D(u_texture, v_texCoords).rgba;\n    gl_FragColor = vec4(vec3(" + var1.r + ", " + var1.g + ", " + var1.b + "), color.a);\n\n}");
      }

      return o;
   }
}
