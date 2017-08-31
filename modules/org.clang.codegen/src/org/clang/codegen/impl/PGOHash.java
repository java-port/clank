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

package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.endian.EndianGlobals;
import org.llvm.support.llvm.support.endian;
import org.llvm.support.llvm.support.endianness;
import static org.llvm.support.llvm.support.unaligned;

/// \brief Stable hasher for PGO region counters.
///
/// PGOHash produces a stable hash of a given function's control flow.
///
/// Changing the output of this hash will invalidate all previously generated
/// profiles -- i.e., don't do it.
///
/// \note  When this hash does eventually change (years?), we still need to
/// support old hashes.  We'll need to pull in the version number from the
/// profile data format and use the matching hash function.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PGOHash">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 61,
 FQN="(anonymous namespace)::PGOHash", NM="_ZN12_GLOBAL__N_17PGOHashE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_17PGOHashE")
//</editor-fold>
public class PGOHash {
  private long/*uint64_t*/ Working;
  private /*uint*/int Count;
  private MD5 MD5;
  
  private static /*const*/int NumBitsPerType = 6;
  private static /*const*//*uint*/int NumTypesPerWord = $div_uint($sizeof_ULong() * 8, NumBitsPerType);
  private static /*const*//*uint*/int TooBig = 1/*U*/ << NumBitsPerType;
/*public:*/
  /// \brief Hash values for AST nodes.
  ///
  /// Distinct values for AST nodes that have region counters attached.
  ///
  /// These values must be stable.  All new members must be added at the end,
  /// and no members should be removed.  Changing the enumeration value for an
  /// AST node will affect the hash of every function that contains that node.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PGOHash::HashType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 78,
   FQN="(anonymous namespace)::PGOHash::HashType", NM="_ZN12_GLOBAL__N_17PGOHash8HashTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_17PGOHash8HashTypeE")
  //</editor-fold>
  public enum HashType/* : unsigned char*/ implements Native.NativeUCharEnum {
    None($int2uchar(0)),
    LabelStmt($int2uchar(1)),
    WhileStmt(LabelStmt.getValue() + 1),
    DoStmt(WhileStmt.getValue() + 1),
    ForStmt(DoStmt.getValue() + 1),
    CXXForRangeStmt(ForStmt.getValue() + 1),
    ObjCForCollectionStmt(CXXForRangeStmt.getValue() + 1),
    SwitchStmt(ObjCForCollectionStmt.getValue() + 1),
    CaseStmt(SwitchStmt.getValue() + 1),
    DefaultStmt(CaseStmt.getValue() + 1),
    IfStmt(DefaultStmt.getValue() + 1),
    CXXTryStmt(IfStmt.getValue() + 1),
    CXXCatchStmt(CXXTryStmt.getValue() + 1),
    ConditionalOperator(CXXCatchStmt.getValue() + 1),
    BinaryOperatorLAnd(ConditionalOperator.getValue() + 1),
    BinaryOperatorLOr(BinaryOperatorLAnd.getValue() + 1),
    BinaryConditionalOperator(BinaryOperatorLOr.getValue() + 1),
    
    // Keep this last.  It's for the static assert that follows.
    LastHashType(BinaryConditionalOperator.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static HashType valueOf(/*uchar*/byte val) {
      HashType out = valueOf((int)val);
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
      return out;
    }
    public static HashType valueOf(int val) {
      HashType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final HashType[] VALUES;
      private static final HashType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (HashType kind : HashType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new HashType[min < 0 ? (1-min) : 0];
        VALUES = new HashType[max >= 0 ? (1+max) : 0];
        for (HashType kind : HashType.values()) {
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

    private final /*uchar*/byte value;
    private HashType(int val) { this.value = (/*uchar*/byte)val;}
    @Override public final /*uchar*/byte getValue() { return value;}
    //</editor-fold>
  };
  static { static_assert($lesseq_uchar_uint(HashType.LastHashType.getValue(), TooBig), $("Too many types in HashType")); };
  
  // TODO: When this format changes, take in a version number here, and use the
  // old hash calculation for file formats that used the old hash.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PGOHash::PGOHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 104,
   FQN="(anonymous namespace)::PGOHash::PGOHash", NM="_ZN12_GLOBAL__N_17PGOHashC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_17PGOHashC1Ev")
  //</editor-fold>
  public PGOHash() {
    // : Working(0), Count(0), MD5() 
    //START JInit
    this.Working = $int2ulong(0);
    this.Count = 0;
    this.MD5 = new MD5();
    //END JInit
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PGOHash::combine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 577,
   FQN="(anonymous namespace)::PGOHash::combine", NM="_ZN12_GLOBAL__N_17PGOHash7combineENS0_8HashTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_17PGOHash7combineENS0_8HashTypeE")
  //</editor-fold>
  public void combine(HashType Type) {
    // Check that we never combine 0 and only have six bits.
    assert ((Type.getValue() != 0)) : "Hash is invalid: unexpected type 0";
    assert (Unsigned.$less_uchar_uint(Type.getValue(), TooBig)) : "Hash is invalid: too many types";
    
    // Pass through MD5 if enough work has built up.
    if ((Count != 0) && $rem_uint(Count, NumTypesPerWord) == 0) {
      //JAVA: using namespace llvm::support;
      final long Swapped = endian.byte_swap(Working, endianness.little);
      MD5.update(Swapped);
      Working = $int2ulong(0);
    }

    // Accumulate the current type.
    ++Count;
    Working = Working << NumBitsPerType | Type.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PGOHash::finalize">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 595,
   FQN="(anonymous namespace)::PGOHash::finalize", NM="_ZN12_GLOBAL__N_17PGOHash8finalizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_17PGOHash8finalizeEv")
  //</editor-fold>
  public long/*uint64_t*/ _finalize() {
    // Use Working as the hash directly if we never used MD5.
    if ($lesseq_uint(Count, NumTypesPerWord)) {
      // No need to byte swap here, since none of the math was endian-dependent.
      // This number will be byte-swapped as required on endianness transitions,
      // so we will see the same value on the other side.
      return Working;
    }
    
    // Check for remaining work in Working.
    if ((Working != 0)) {
      // JAVA: long=>char*=>long
      byte[] ulongToBytes = ByteUtils.ulongToBytes(Working);
      MD5.update(new ArrayRefChar(ulongToBytes));
      Working = ByteUtils.bytesToULong(ulongToBytes);
    }
    
    // Finalize the MD5 and return the hash.
    byte/*uint8_t*/ Result[/*16*/] = new$char(-1);
    MD5.__final(Result);
    //JAVA: using namespace llvm::support;
    //return endian.<long/*uint64_t*/, endianness.little, unaligned>read(Result);
    return EndianGlobals.readNext_uint64(endianness.little, unaligned, create_char$ptr(Result));
  }

  
  @Override public String toString() {
    return "" + "Working=" + Working // NOI18N
              + ", Count=" + Count // NOI18N
              + ", MD5=" + MD5; // NOI18N
  }
}
