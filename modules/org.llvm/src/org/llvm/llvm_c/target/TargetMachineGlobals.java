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
package org.llvm.llvm_c.target;

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


//<editor-fold defaultstate="collapsed" desc="static type TargetMachineGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.llvm_c.target.TargetMachineGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_LLVMCodeGenFileType;_LLVMCodeGenOptLevel;_LLVMCodeModel;_LLVMRelocMode; -static-type=TargetMachineGlobals -package=org.llvm.llvm_c.target")
//</editor-fold>
public final class TargetMachineGlobals {

//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/TargetMachine.h", line = 31,
 FQN="(anonymous)", NM="_LLVMCodeGenOptLevel",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_LLVMCodeGenOptLevel")
//</editor-fold>
public enum LLVMCodeGenOptLevel implements Native.NativeUIntEnum {
  LLVMCodeGenLevelNone(0),
  LLVMCodeGenLevelLess(LLVMCodeGenLevelNone.getValue() + 1),
  LLVMCodeGenLevelDefault(LLVMCodeGenLevelLess.getValue() + 1),
  LLVMCodeGenLevelAggressive(LLVMCodeGenLevelDefault.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMCodeGenOptLevel valueOf(int val) {
    LLVMCodeGenOptLevel out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMCodeGenOptLevel[] VALUES;
    private static final LLVMCodeGenOptLevel[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMCodeGenOptLevel kind : LLVMCodeGenOptLevel.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMCodeGenOptLevel[min < 0 ? (1-min) : 0];
      VALUES = new LLVMCodeGenOptLevel[max >= 0 ? (1+max) : 0];
      for (LLVMCodeGenOptLevel kind : LLVMCodeGenOptLevel.values()) {
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
  private LLVMCodeGenOptLevel(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/TargetMachine.h", line = 38,
 FQN="(anonymous)", NM="_LLVMRelocMode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_LLVMRelocMode")
//</editor-fold>
public enum LLVMRelocMode implements Native.NativeUIntEnum {
  LLVMRelocDefault(0),
  LLVMRelocStatic(LLVMRelocDefault.getValue() + 1),
  LLVMRelocPIC(LLVMRelocStatic.getValue() + 1),
  LLVMRelocDynamicNoPic(LLVMRelocPIC.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMRelocMode valueOf(int val) {
    LLVMRelocMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMRelocMode[] VALUES;
    private static final LLVMRelocMode[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMRelocMode kind : LLVMRelocMode.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMRelocMode[min < 0 ? (1-min) : 0];
      VALUES = new LLVMRelocMode[max >= 0 ? (1+max) : 0];
      for (LLVMRelocMode kind : LLVMRelocMode.values()) {
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
  private LLVMRelocMode(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/TargetMachine.h", line = 45,
 FQN="(anonymous)", NM="_LLVMCodeModel",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_LLVMCodeModel")
//</editor-fold>
public enum LLVMCodeModel implements Native.NativeUIntEnum {
  LLVMCodeModelDefault(0),
  LLVMCodeModelJITDefault(LLVMCodeModelDefault.getValue() + 1),
  LLVMCodeModelSmall(LLVMCodeModelJITDefault.getValue() + 1),
  LLVMCodeModelKernel(LLVMCodeModelSmall.getValue() + 1),
  LLVMCodeModelMedium(LLVMCodeModelKernel.getValue() + 1),
  LLVMCodeModelLarge(LLVMCodeModelMedium.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMCodeModel valueOf(int val) {
    LLVMCodeModel out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMCodeModel[] VALUES;
    private static final LLVMCodeModel[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMCodeModel kind : LLVMCodeModel.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMCodeModel[min < 0 ? (1-min) : 0];
      VALUES = new LLVMCodeModel[max >= 0 ? (1+max) : 0];
      for (LLVMCodeModel kind : LLVMCodeModel.values()) {
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
  private LLVMCodeModel(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/TargetMachine.h", line = 54,
 FQN="(anonymous)", NM="_LLVMCodeGenFileType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/tools/llvm-c-test/include-all.c -nm=_LLVMCodeGenFileType")
//</editor-fold>
public enum LLVMCodeGenFileType implements Native.NativeUIntEnum {
  LLVMAssemblyFile(0),
  LLVMObjectFile(LLVMAssemblyFile.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMCodeGenFileType valueOf(int val) {
    LLVMCodeGenFileType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMCodeGenFileType[] VALUES;
    private static final LLVMCodeGenFileType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMCodeGenFileType kind : LLVMCodeGenFileType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMCodeGenFileType[min < 0 ? (1-min) : 0];
      VALUES = new LLVMCodeGenFileType[max >= 0 ? (1+max) : 0];
      for (LLVMCodeGenFileType kind : LLVMCodeGenFileType.values()) {
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
  private LLVMCodeGenFileType(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}
} // END OF class TargetMachineGlobals
