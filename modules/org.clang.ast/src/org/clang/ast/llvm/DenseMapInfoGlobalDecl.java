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

package org.clang.ast.llvm;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.GlobalDecl.$eq_GlobalDecl$C;

//<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::GlobalDecl>">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 98,
 FQN="llvm::DenseMapInfo<clang::GlobalDecl>", NM="_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEEE")
//</editor-fold>
public class/*struct*/ DenseMapInfoGlobalDecl implements org.llvm.adt.DenseMapInfo<GlobalDecl> {
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::GlobalDecl>::getEmptyKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 99,
   FQN="llvm::DenseMapInfo<clang::GlobalDecl>::getEmptyKey", NM="_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEE11getEmptyKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEE11getEmptyKeyEv")
  //</editor-fold>
  public /*static*/ /*inline*/ GlobalDecl getEmptyKey() {
    return EmptyKey;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::GlobalDecl>::getTombstoneKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 103,
   FQN="llvm::DenseMapInfo<clang::GlobalDecl>::getTombstoneKey", NM="_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEE15getTombstoneKeyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEE15getTombstoneKeyEv")
  //</editor-fold>
  public /*static*/ /*inline*/ GlobalDecl getTombstoneKey() {
    return TombstoneKey;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::GlobalDecl>::getHashValue">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 108,
   FQN="llvm::DenseMapInfo<clang::GlobalDecl>::getHashValue", NM="_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEE12getHashValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEE12getHashValueES2_")
  //</editor-fold>
  public /*static*/ /*uint*/int getHashValue(GlobalDecl GD) {
    assert GD != EmptyKey : "must not be called for emptyKey";
    assert GD != TombstoneKey : "must not be called for tombstoneKey";        
    //DenseMapInfoT$P<GlobalDecl/*void P*/ >.getHashValue(GD.getAsOpaquePtr());
    return GD.$hashcode();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DenseMapInfo<clang::GlobalDecl>::isEqual">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/GlobalDecl.h", line = 112,
   FQN="llvm::DenseMapInfo<clang::GlobalDecl>::isEqual", NM="_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEE7isEqualES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm12DenseMapInfoIN5clang10GlobalDeclEE7isEqualES2_S2_")
  //</editor-fold>
  public /*static*/ boolean isEqual(GlobalDecl LHS, 
         GlobalDecl RHS) {
    assert LHS != EmptyKey : "LHS: must not be called for emptyKey";
    assert LHS != TombstoneKey : "LHS: must not be called for tombstoneKey";    
    assert RHS != EmptyKey : "RHS: must not be called for emptyKey";
    assert RHS != TombstoneKey : "RHS: must not be called for tombstoneKey";           
    return $eq_GlobalDecl$C(LHS, RHS);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

    @Override
    public boolean isKeyPointerLike() {
      return false;
    }

    private static final DenseMapInfoGlobalDecl $INFO = new DenseMapInfoGlobalDecl();
    private static final GlobalDecl EmptyKey = new GlobalDecl();//new GlobalDecl();
    private static final GlobalDecl TombstoneKey = new GlobalDecl();//GlobalDecl.getFromOpaquePtr(reinterpret_cast(GlobalDecl/*void P*/ .class, -1));
    public static DenseMapInfoGlobalDecl $Info() {
      return $INFO;
    }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return ""; // NOI18N
  }
}
