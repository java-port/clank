/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.llvm.llvm_c;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.object.*;;


//<editor-fold defaultstate="collapsed" desc="static type ltoGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.llvm_c.ltoGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_lto_codegen_diagnostic_severity_t;_lto_codegen_model;_lto_debug_model;_lto_symbol_attributes; -static-type=ltoGlobals -package=org.llvm.llvm_c")
//</editor-fold>
public final class ltoGlobals {


/**
* \since prior to LTO_API_VERSION=3
*/
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/lto.h", line = 52,
 FQN="(anonymous)", NM="_lto_symbol_attributes",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_lto_symbol_attributes")
//</editor-fold>
public static final class/*enum*/ lto_symbol_attributes {
  public static final /*uint*/int LTO_SYMBOL_ALIGNMENT_MASK = 0x0000001F; /* log2 of alignment */
  public static final /*uint*/int LTO_SYMBOL_PERMISSIONS_MASK = 0x000000E0;
  public static final /*uint*/int LTO_SYMBOL_PERMISSIONS_CODE = 0x000000A0;
  public static final /*uint*/int LTO_SYMBOL_PERMISSIONS_DATA = 0x000000C0;
  public static final /*uint*/int LTO_SYMBOL_PERMISSIONS_RODATA = 0x00000080;
  public static final /*uint*/int LTO_SYMBOL_DEFINITION_MASK = 0x00000700;
  public static final /*uint*/int LTO_SYMBOL_DEFINITION_REGULAR = 0x00000100;
  public static final /*uint*/int LTO_SYMBOL_DEFINITION_TENTATIVE = 0x00000200;
  public static final /*uint*/int LTO_SYMBOL_DEFINITION_WEAK = 0x00000300;
  public static final /*uint*/int LTO_SYMBOL_DEFINITION_UNDEFINED = 0x00000400;
  public static final /*uint*/int LTO_SYMBOL_DEFINITION_WEAKUNDEF = 0x00000500;
  public static final /*uint*/int LTO_SYMBOL_SCOPE_MASK = 0x00003800;
  public static final /*uint*/int LTO_SYMBOL_SCOPE_INTERNAL = 0x00000800;
  public static final /*uint*/int LTO_SYMBOL_SCOPE_HIDDEN = 0x00001000;
  public static final /*uint*/int LTO_SYMBOL_SCOPE_PROTECTED = 0x00002000;
  public static final /*uint*/int LTO_SYMBOL_SCOPE_DEFAULT = 0x00001800;
  public static final /*uint*/int LTO_SYMBOL_SCOPE_DEFAULT_CAN_BE_HIDDEN = 0x00002800;
  public static final /*uint*/int LTO_SYMBOL_COMDAT = 0x00004000;
  public static final /*uint*/int LTO_SYMBOL_ALIAS = 0x00008000;
}

/**
* \since prior to LTO_API_VERSION=3
*/
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/lto.h", line = 77,
 FQN="(anonymous)", NM="_lto_debug_model",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_lto_debug_model")
//</editor-fold>
public enum lto_debug_model implements Native.NativeUIntEnum {
  LTO_DEBUG_MODEL_NONE(0),
  LTO_DEBUG_MODEL_DWARF(1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static lto_debug_model valueOf(int val) {
    lto_debug_model out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final lto_debug_model[] VALUES;
    private static final lto_debug_model[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (lto_debug_model kind : lto_debug_model.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new lto_debug_model[min < 0 ? (1-min) : 0];
      VALUES = new lto_debug_model[max >= 0 ? (1+max) : 0];
      for (lto_debug_model kind : lto_debug_model.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private lto_debug_model(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}

/**
* \since prior to LTO_API_VERSION=3
*/
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/lto.h", line = 85,
 FQN="(anonymous)", NM="_lto_codegen_model",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_lto_codegen_model")
//</editor-fold>
public enum lto_codegen_model implements Native.NativeUIntEnum {
  LTO_CODEGEN_PIC_MODEL_STATIC(0),
  LTO_CODEGEN_PIC_MODEL_DYNAMIC(1),
  LTO_CODEGEN_PIC_MODEL_DYNAMIC_NO_PIC(2),
  LTO_CODEGEN_PIC_MODEL_DEFAULT(3);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static lto_codegen_model valueOf(int val) {
    lto_codegen_model out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final lto_codegen_model[] VALUES;
    private static final lto_codegen_model[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (lto_codegen_model kind : lto_codegen_model.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new lto_codegen_model[min < 0 ? (1-min) : 0];
      VALUES = new lto_codegen_model[max >= 0 ? (1+max) : 0];
      for (lto_codegen_model kind : lto_codegen_model.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private lto_codegen_model(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}

/**
* Diagnostic severity.
*
* \since LTO_API_VERSION=7
*/
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/lto.h", line = 305,
 FQN="(anonymous)", NM="_lto_codegen_diagnostic_severity_t",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_lto_codegen_diagnostic_severity_t")
//</editor-fold>
public enum lto_codegen_diagnostic_severity_t implements Native.NativeUIntEnum {
  LTO_DS_ERROR(0),
  LTO_DS_WARNING(1),
  LTO_DS_REMARK(3), // Added in LTO_API_VERSION=10.
  LTO_DS_NOTE(2);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static lto_codegen_diagnostic_severity_t valueOf(int val) {
    lto_codegen_diagnostic_severity_t out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final lto_codegen_diagnostic_severity_t[] VALUES;
    private static final lto_codegen_diagnostic_severity_t[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (lto_codegen_diagnostic_severity_t kind : lto_codegen_diagnostic_severity_t.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new lto_codegen_diagnostic_severity_t[min < 0 ? (1-min) : 0];
      VALUES = new lto_codegen_diagnostic_severity_t[max >= 0 ? (1+max) : 0];
      for (lto_codegen_diagnostic_severity_t kind : lto_codegen_diagnostic_severity_t.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint*/int value;
  private lto_codegen_diagnostic_severity_t(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
} // END OF class ltoGlobals
