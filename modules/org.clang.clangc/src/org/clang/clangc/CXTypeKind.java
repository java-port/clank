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

package org.clang.clangc;

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
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.cl.*;
import org.clank.java.stdimpl.aliases.*;
import org.clang.basic.target.*;;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.clangc.api.*;
import org.clang.clangc.api.buildsystem.*;
import org.clang.clangc.java.ClangCFunctionPointers.*;
import org.clang.clangc.CXStringGlobals.*;
import org.clang.clangc.IndexGlobals.*;


/**
* @}
*/

/**
* \defgroup CINDEX_TYPES Type information for CXCursors
*
* @{
*/

/**
* \brief Describes the kind of type
*/
//<editor-fold defaultstate="collapsed" desc="CXTypeKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang-c/Index.h", line = 2919,
 FQN="CXTypeKind", NM="_Z10CXTypeKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CIndex.cpp -nm=_Z10CXTypeKind")
//</editor-fold>
public enum CXTypeKind implements Native.ComparableLower {
  /**
  * \brief Represents an invalid type (e.g., where no type is available).
  */
  CXType_Invalid(0),
  
  /**
  * \brief A type whose specific kind is not exposed via this
  * interface.
  */
  CXType_Unexposed(1),
  
  /* Builtin types */
  CXType_Void(2),
  CXType_Bool(3),
  CXType_Char_U(4),
  CXType_UChar(5),
  CXType_Char16(6),
  CXType_Char32(7),
  CXType_UShort(8),
  CXType_UInt(9),
  CXType_ULong(10),
  CXType_ULongLong(11),
  CXType_UInt128(12),
  CXType_Char_S(13),
  CXType_SChar(14),
  CXType_WChar(15),
  CXType_Short(16),
  CXType_Int(17),
  CXType_Long(18),
  CXType_LongLong(19),
  CXType_Int128(20),
  CXType_Float(21),
  CXType_Double(22),
  CXType_LongDouble(23),
  CXType_NullPtr(24),
  CXType_Overload(25),
  CXType_Dependent(26),
  CXType_ObjCId(27),
  CXType_ObjCClass(28),
  CXType_ObjCSel(29),
  CXType_Float128(30),
  CXType_FirstBuiltin(CXTypeKind.CXType_Void.getValue()),
  CXType_LastBuiltin(CXTypeKind.CXType_ObjCSel.getValue()),
  
  CXType_Complex(100),
  CXType_Pointer(101),
  CXType_BlockPointer(102),
  CXType_LValueReference(103),
  CXType_RValueReference(104),
  CXType_Record(105),
  CXType_Enum(106),
  CXType_Typedef(107),
  CXType_ObjCInterface(108),
  CXType_ObjCObjectPointer(109),
  CXType_FunctionNoProto(110),
  CXType_FunctionProto(111),
  CXType_ConstantArray(112),
  CXType_Vector(113),
  CXType_IncompleteArray(114),
  CXType_VariableArray(115),
  CXType_DependentSizedArray(116),
  CXType_MemberPointer(117),
  CXType_Auto(118),
  
  /**
  * \brief Represents a type that was referred to using an elaborated type keyword.
  *
  * E.g., struct S, or via a qualified name, e.g., N::M::type, or both.
  */
  CXType_Elaborated(119);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CXTypeKind valueOf(int val) {
    CXTypeKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CXTypeKind[] VALUES;
    private static final CXTypeKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CXTypeKind kind : CXTypeKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CXTypeKind[min < 0 ? (1-min) : 0];
      VALUES = new CXTypeKind[max >= 0 ? (1+max) : 0];
      for (CXTypeKind kind : CXTypeKind.values()) {
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
  private CXTypeKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CXTypeKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CXTypeKind)obj).value);}
  //</editor-fold>
}
