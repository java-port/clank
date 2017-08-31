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
import org.clank.support.JavaDifferentiators.*;


/// A std::pair-like structure for storing a qualified type split
/// into its local qualifiers and its locally-unqualified type.
//<editor-fold defaultstate="collapsed" desc="clang::SplitQualType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 541,
 FQN="clang::SplitQualType", NM="_ZN5clang13SplitQualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13SplitQualTypeE")
//</editor-fold>
public class/*struct*/ SplitQualType {
  /// The locally-unqualified type.
  public /*const*/ Type /*P*/ Ty;
  
  /// The local qualifiers.
  public Qualifiers Quals;
  
  //<editor-fold defaultstate="collapsed" desc="clang::SplitQualType::SplitQualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 548,
   FQN="clang::SplitQualType::SplitQualType", NM="_ZN5clang13SplitQualTypeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13SplitQualTypeC1Ev")
  //</editor-fold>
  public SplitQualType() {
    // : Ty(null), Quals() 
    //START JInit
    this.Ty = null;
    this.Quals = new Qualifiers();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SplitQualType::SplitQualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 549,
   FQN="clang::SplitQualType::SplitQualType", NM="_ZN5clang13SplitQualTypeC1EPKNS_4TypeENS_10QualifiersE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13SplitQualTypeC1EPKNS_4TypeENS_10QualifiersE")
  //</editor-fold>
  public SplitQualType(/*const*/ Type /*P*/ ty, Qualifiers qs) {
    // : Ty(ty), Quals(qs) 
    //START JInit
    this.Ty = ty;
    this.Quals = new Qualifiers(qs);
    //END JInit
  }

  
  
  // Inline function definitions.
  //<editor-fold defaultstate="collapsed" desc="clang::SplitQualType::getSingleStepDesugaredType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5252,
   FQN="clang::SplitQualType::getSingleStepDesugaredType", NM="_ZNK5clang13SplitQualType26getSingleStepDesugaredTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13SplitQualType26getSingleStepDesugaredTypeEv")
  //</editor-fold>
  public /*inline*/ SplitQualType getSingleStepDesugaredType() /*const*/ {
    SplitQualType desugar = Ty.getLocallyUnqualifiedSingleStepDesugaredType().split();
    desugar.Quals.addConsistentQualifiers(new Qualifiers(Quals));
    return desugar;
  }
 // end of this file
  
  // Make std::tie work.
  //<editor-fold defaultstate="collapsed" desc="clang::SplitQualType::asPair">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 554,
   FQN="clang::SplitQualType::asPair", NM="_ZNK5clang13SplitQualType6asPairEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang13SplitQualType6asPairEv")
  //</editor-fold>
  public std.pair</*const*/ Type /*P*/ , Qualifiers> asPair() /*const*/ {
    return new std.pairPtrType</*const*/ Type /*P*/ , Qualifiers>(Ty, Quals);
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 558,
   FQN="clang::operator==", NM="_ZN5clangeqENS_13SplitQualTypeES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clangeqENS_13SplitQualTypeES0_")
  //</editor-fold>
  public static boolean $eq_SplitQualType(SplitQualType a, SplitQualType b) {
    return a.Ty == b.Ty && a.Quals.$eq(/*NO_COPY*/b.Quals);
  }

  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 561,
   FQN="clang::operator!=", NM="_ZN5clangneENS_13SplitQualTypeES0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clangneENS_13SplitQualTypeES0_")
  //</editor-fold>
  public static boolean $noteq_SplitQualType(SplitQualType a, SplitQualType b) {
    return a.Ty != b.Ty || a.Quals.$noteq(/*NO_COPY*/b.Quals);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SplitQualType::SplitQualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 541,
   FQN="clang::SplitQualType::SplitQualType", NM="_ZN5clang13SplitQualTypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13SplitQualTypeC1ERKS0_")
  //</editor-fold>
  public /*inline*/ SplitQualType(final /*const*/ SplitQualType /*&*/ $Prm0) {
    // : Ty(.Ty), Quals(.Quals) 
    //START JInit
    this.Ty = $Prm0.Ty;
    this.Quals = new Qualifiers($Prm0.Quals);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SplitQualType::SplitQualType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 541,
   FQN="clang::SplitQualType::SplitQualType", NM="_ZN5clang13SplitQualTypeC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13SplitQualTypeC1EOS0_")
  //</editor-fold>
  public /*inline*/ SplitQualType(JD$Move _dparam, final SplitQualType /*&&*/$Prm0) {
    // : Ty(static_cast<SplitQualType &&>().Ty), Quals(static_cast<SplitQualType &&>().Quals) 
    //START JInit
    this.Ty = $Prm0.Ty;
    this.Quals = new Qualifiers(JD$Move.INSTANCE, $Prm0.Quals);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::SplitQualType::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 541,
   FQN="clang::SplitQualType::operator=", NM="_ZN5clang13SplitQualTypeaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang13SplitQualTypeaSEOS0_")
  //</editor-fold>
  public /*inline*/ SplitQualType /*&*/ $assignMove(final SplitQualType /*&&*/$Prm0) {
    this.Ty = $Prm0.Ty;
    this.Quals.$assignMove($Prm0.Quals);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Ty=" + Ty // NOI18N
              + ", Quals=" + Quals; // NOI18N
  }
}
