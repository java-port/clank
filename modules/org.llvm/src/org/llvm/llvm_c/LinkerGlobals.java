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
import org.llvm.object.*;
import org.llvm.llvmc.*;
import org.llvm.java.LlvmFunctionPointers.*;
import org.llvm.debuginfo.*;
import org.llvm.llvmc.java.LlvmCFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type LinkerGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.llvm_c.LinkerGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_LLVMLinkerMode;_Z16LLVMLinkModules2; -static-type=LinkerGlobals -package=org.llvm.llvm_c")
//</editor-fold>
public final class LinkerGlobals {


/* This enum is provided for backwards-compatibility only. It has no effect. */
//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm-c/Linker.h", line = 24,
 FQN="(anonymous)", NM="_LLVMLinkerMode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_LLVMLinkerMode")
//</editor-fold>
public enum LLVMLinkerMode implements Native.NativeUIntEnum {
  LLVMLinkerDestroySource(0), /* This is the default behavior. */
  LLVMLinkerPreserveSource_Removed(1/* This option has been deprecated and
  should not be used. */);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMLinkerMode valueOf(int val) {
    LLVMLinkerMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMLinkerMode[] VALUES;
    private static final LLVMLinkerMode[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMLinkerMode kind : LLVMLinkerMode.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMLinkerMode[min < 0 ? (1-min) : 0];
      VALUES = new LLVMLinkerMode[max >= 0 ? (1+max) : 0];
      for (LLVMLinkerMode kind : LLVMLinkerMode.values()) {
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
  private LLVMLinkerMode(int val) { this.value = (/*uint*/int)val;}
  @Override public final /*uint*/int getValue() { return value;}
  //</editor-fold>
}

/* Links the source module into the destination module. The source module is
* destroyed.
* The return value is true if an error occurred, false otherwise.
* Use the diagnostic handler to get any diagnostic message.
*/

//===----------------------------------------------------------------------===//
// C API.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="LLVMLinkModules2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp", line = 629,
 FQN="LLVMLinkModules2", NM="_Z16LLVMLinkModules2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/LinkModules.cpp -nm=_Z16LLVMLinkModules2")
//</editor-fold>
public static int LLVMLinkModules2( LLVMOpaqueModule /*P*/ Dest,  LLVMOpaqueModule /*P*/ Src) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class LinkerGlobals
