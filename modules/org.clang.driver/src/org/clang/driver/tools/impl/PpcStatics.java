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
package org.clang.driver.tools.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
;
import static org.clang.basic.BasicClangGlobals.*;
;


//<editor-fold defaultstate="collapsed" desc="static type PpcStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3ppc12hasPPCAbiArgERKN4llvm3opt7ArgListEPKc;_ZN5clang6driver5tools3ppc14getPPCFloatABIERKNS0_6DriverERKN4llvm3opt7ArgListE;_ZN5clang6driver5tools3ppc8FloatABIE; -static-type=PpcStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class PpcStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ppc::hasPPCAbiArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1705,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1535,
 FQN="clang::driver::tools::ppc::hasPPCAbiArg", NM="_ZN5clang6driver5tools3ppc12hasPPCAbiArgERKN4llvm3opt7ArgListEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3ppc12hasPPCAbiArgERKN4llvm3opt7ArgListEPKc")
//</editor-fold>
public static boolean hasPPCAbiArg(/*const*/ ArgList /*&*/ Args, /*const*/char$ptr/*char P*/ Value) {
  Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mabi_EQ.getValue()));
  return (A != null) && ($eq_StringRef(/*STRINGREF_STR*/A.getValue(), /*STRINGREF_STR*/Value));
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ppc::FloatABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 771,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 767,
 FQN="clang::driver::tools::ppc::FloatABI", NM="_ZN5clang6driver5tools3ppc8FloatABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3ppc8FloatABIE")
//</editor-fold>
public enum /*class */FloatABI/* : int*/ implements Native.ComparableLower {
  Invalid(0),
  Soft(Invalid.getValue() + 1),
  Hard(Soft.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static FloatABI valueOf(int val) {
    FloatABI out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final FloatABI[] VALUES;
    private static final FloatABI[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (FloatABI kind : FloatABI.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new FloatABI[min < 0 ? (1-min) : 0];
      VALUES = new FloatABI[max >= 0 ? (1+max) : 0];
      for (FloatABI kind : FloatABI.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private FloatABI(int val) { this.value = (int)val;}
  public int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((FloatABI)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((FloatABI)obj).value);}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ppc::getPPCFloatABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1619,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1449,
 FQN="clang::driver::tools::ppc::getPPCFloatABI", NM="_ZN5clang6driver5tools3ppc14getPPCFloatABIERKNS0_6DriverERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3ppc14getPPCFloatABIERKNS0_6DriverERKN4llvm3opt7ArgListE")
//</editor-fold>
public static PpcStatics.FloatABI getPPCFloatABI(/*const*/ Driver /*&*/ D, /*const*/ ArgList /*&*/ Args) {
  PpcStatics.FloatABI ABI = PpcStatics.FloatABI.Invalid;
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_msoft_float.getValue()), new OptSpecifier(options.ID.OPT_mhard_float.getValue()), 
        new OptSpecifier(options.ID.OPT_mfloat_abi_EQ.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_msoft_float.getValue()))) {
        ABI = PpcStatics.FloatABI.Soft;
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mhard_float.getValue()))) {
        ABI = PpcStatics.FloatABI.Hard;
      } else {
        ABI = new StringSwitch<PpcStatics.FloatABI>(/*STRINGREF_STR*/A.getValue()).
            Case(/*KEEP_STR*/"soft", PpcStatics.FloatABI.Soft).
            Case(/*KEEP_STR*/"hard", PpcStatics.FloatABI.Hard).
            Default(PpcStatics.FloatABI.Invalid);
        if (ABI == PpcStatics.FloatABI.Invalid && !new StringRef(A.getValue()).empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_mfloat_abi)), new StringRef(A.getAsString(Args))));
            ABI = PpcStatics.FloatABI.Hard;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // If unspecified, choose the default based on the platform.
  if (ABI == PpcStatics.FloatABI.Invalid) {
    ABI = PpcStatics.FloatABI.Hard;
  }
  
  return ABI;
}

} // END OF class PpcStatics
