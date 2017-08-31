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

package org.llvm.transforms.utils;

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
import org.llvm.ir.*;


/// These are flags that the value mapping APIs allow.
//<editor-fold defaultstate="collapsed" desc="llvm::RemapFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 56,
 FQN="llvm::RemapFlags", NM="_ZN4llvm10RemapFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Linker/IRMover.cpp -nm=_ZN4llvm10RemapFlagsE")
//</editor-fold>
public enum RemapFlags implements Native.ComparableLower {
  RF_None(0),
  
  /// If this flag is set, the remapper knows that only local values within a
  /// function (such as an instruction or argument) are mapped, not global
  /// values like functions and global metadata.
  RF_NoModuleLevelChanges(1),
  
  /// If this flag is set, the remapper ignores missing function-local entries
  /// (Argument, Instruction, BasicBlock) that are not in the value map.  If it
  /// is unset, it aborts if an operand is asked to be remapped which doesn't
  /// exist in the mapping.
  ///
  /// There are no such assertions in MapValue(), whose results are almost
  /// unchanged by this flag.  This flag mainly changes the assertion behaviour
  /// in RemapInstruction().
  ///
  /// Since an Instruction's metadata operands (even that point to SSA values)
  /// aren't guaranteed to be dominated by their definitions, MapMetadata will
  /// return "!{}" instead of "null" for \a LocalAsMetadata instances whose SSA
  /// values are unmapped when this flag is set.  Otherwise, \a MapValue()
  /// completely ignores this flag.
  ///
  /// \a MapMetadata() always ignores this flag.
  RF_IgnoreMissingLocals(2),
  
  /// Instruct the remapper to move distinct metadata instead of duplicating it
  /// when there are module-level changes.
  RF_MoveDistinctMDs(4),
  
  /// Any global values not in value map are mapped to null instead of mapping
  /// to self.  Illegal if RF_IgnoreMissingLocals is also set.
  RF_NullMapMissingGlobalValues(8);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static RemapFlags valueOf(int val) {
    RemapFlags out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final RemapFlags[] VALUES;
    private static final RemapFlags[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (RemapFlags kind : RemapFlags.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new RemapFlags[min < 0 ? (1-min) : 0];
      VALUES = new RemapFlags[max >= 0 ? (1+max) : 0];
      for (RemapFlags kind : RemapFlags.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private RemapFlags(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((RemapFlags)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((RemapFlags)obj).value);}
  //</editor-fold>
}
