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

package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;


/// \brief Used by IntegerLiteral/FloatingLiteral to store the numeric without
/// leaking memory.
///
/// For large floats/integers, APFloat/APInt will allocate memory from the heap
/// to represent these numbers.  Unfortunately, when we use a BumpPtrAllocator
/// to allocate IntegerLiteral/FloatingLiteral nodes the memory associated with
/// the APFloat/APInt values will never get freed. APNumericStorage uses
/// ASTContext's allocator for memory allocation.
//<editor-fold defaultstate="collapsed" desc="clang::APNumericStorage">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*unfold union in fields container*/,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1221,
 FQN="clang::APNumericStorage", NM="_ZN5clang16APNumericStorageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16APNumericStorageE")
//</editor-fold>
public interface/*class*/ APNumericStorage {
  @Converted(kind = Converted.Kind.MANUAL_ADDED/*wrapper to keep fields*/)
  public static final class APNumericStorage$Fields {
    //<editor-fold defaultstate="collapsed" desc="clang::APNumericStorage::(anonymous)">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1222,
     FQN="clang::APNumericStorage::(anonymous)", NM="_ZN5clang16APNumericStorageE_Unnamed_union1",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16APNumericStorageE_Unnamed_union1")
    //</editor-fold>
    protected APNumericStorage$Fields() {
      /*Indirect*/VAL = 0;
      BitWidth = 0;    
    }

    // JAVA: unfold union
    // union public/*private*/ static class/*union*/ Unnamed_union1 {
      public long/*uint64_t*/ VAL; ///< Used to store the <= 64 bits integer value.
      public ulong$ptr/*uint64_t P*/ pVal; ///< Used to store the >64 bits integer value.
    // };
    public/*private*/ /*uint*/int BitWidth;
    @Override public String toString() {
      return "[" + BitWidth + "]" + "VAL=" + VAL // NOI18N
                + ", pVal=" + pVal; // NOI18N
    }
  }
  public default APNumericStorage$Fields $APNumericStorage$Fields() {
    throw new UnsupportedOperationException("Why not implemented in derived? " + this.getClass() + ": Keep what was returned from $APNumericStorage in your final field and just return it here.");
  }
  //<editor-fold defaultstate="collapsed" desc="clang::APNumericStorage::hasAllocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1228,
   FQN="clang::APNumericStorage::hasAllocation", NM="_ZNK5clang16APNumericStorage13hasAllocationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16APNumericStorage13hasAllocationEv")
  //</editor-fold>
  public/*private*/ default/*interface*/ boolean hasAllocation() /*const*/ {
    return $greater_uint(APInt.getNumWords($APNumericStorage$Fields().BitWidth), 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APNumericStorage::APNumericStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1230,
   FQN="clang::APNumericStorage::APNumericStorage", NM="_ZN5clang16APNumericStorageC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16APNumericStorageC1ERKS0_")
  //</editor-fold>
  public/*private*/ default/*interface*/ void $APNumericStorage(final /*const*/ APNumericStorage /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::APNumericStorage::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1231,
   FQN="clang::APNumericStorage::operator=", NM="_ZN5clang16APNumericStorageaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16APNumericStorageaSERKS0_")
  //</editor-fold>
  public/*private*/ default/*interface*/ void $assign(final /*const*/ APNumericStorage /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::APNumericStorage::APNumericStorage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1234,
   FQN="clang::APNumericStorage::APNumericStorage", NM="_ZN5clang16APNumericStorageC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16APNumericStorageC1Ev")
  //</editor-fold>
  public/*protected*/ default/*interface*/ APNumericStorage$Fields $APNumericStorage() {
    // : VAL(0), BitWidth(0) 
    //START JInit
    return new APNumericStorage$Fields();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::APNumericStorage::getIntValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1236,
   FQN="clang::APNumericStorage::getIntValue", NM="_ZNK5clang16APNumericStorage11getIntValueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang16APNumericStorage11getIntValueEv")
  //</editor-fold>
  public/*protected*/ default/*interface*/ APInt getIntValue() /*const*/ {
    /*uint*/int NumWords = APInt.getNumWords($APNumericStorage$Fields().BitWidth);
    if ($greater_uint(NumWords, 1)) {
      return new APInt($APNumericStorage$Fields().BitWidth, NumWords, $APNumericStorage$Fields().pVal.$array());
    } else {
      return new APInt($APNumericStorage$Fields().BitWidth, $APNumericStorage$Fields().VAL);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::APNumericStorage::setIntValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 691,
   FQN="clang::APNumericStorage::setIntValue", NM="_ZN5clang16APNumericStorage11setIntValueERKNS_10ASTContextERKN4llvm5APIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang16APNumericStorage11setIntValueERKNS_10ASTContextERKN4llvm5APIntE")
  //</editor-fold>
  public/*protected*/ default/*interface*/ void setIntValue(final /*const*/ ASTContext /*&*/ C, 
             final /*const*/ APInt /*&*/ Val) {
    if (this.hasAllocation()) {
      C.Deallocate($APNumericStorage$Fields().pVal);
    }
    
    $APNumericStorage$Fields().BitWidth = Val.getBitWidth();
    /*uint*/int NumWords = Val.getNumWords();
    /*const*/ulong$ptr/*uint64_t P*/ Words = $tryClone(Val.getRawData());
    if ($greater_uint(NumWords, 1)) {
      $APNumericStorage$Fields().pVal = create_ulong$ptr(/*FIXME:NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
      /*new (C)*/ new$long(NumWords));
      std.copy(Words, Words.$add(NumWords), $APNumericStorage$Fields().pVal);
    } else if (NumWords == 1) {
      $APNumericStorage$Fields().VAL = Words.$at(0);
    } else {
      $APNumericStorage$Fields().VAL = 0;
    }
  }

}
