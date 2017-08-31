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

package org.clang.ast.comments.impl;

import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::SimpleTypoCorrector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 952,
 FQN="clang::comments::(anonymous namespace)::SimpleTypoCorrector", NM="_ZN5clang8comments12_GLOBAL__N_119SimpleTypoCorrectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_119SimpleTypoCorrectorE")
//</editor-fold>
public class SimpleTypoCorrector {
  private StringRef Typo;
  private /*const*//*uint*/int MaxEditDistance;
  
  private /*const*/ NamedDecl /*P*/ BestDecl;
  private /*uint*/int BestEditDistance;
  private /*uint*/int BestIndex;
  private /*uint*/int NextIndex;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::SimpleTypoCorrector::SimpleTypoCorrector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 962,
   FQN="clang::comments::(anonymous namespace)::SimpleTypoCorrector::SimpleTypoCorrector", NM="_ZN5clang8comments12_GLOBAL__N_119SimpleTypoCorrectorC1EN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_119SimpleTypoCorrectorC1EN4llvm9StringRefE")
  //</editor-fold>
  public SimpleTypoCorrector(StringRef Typo) {
    // : Typo(Typo), MaxEditDistance((Typo.size() + 2) / 3), BestDecl(null), BestEditDistance(MaxEditDistance + 1), BestIndex(0), NextIndex(0) 
    //START JInit
    this.Typo = new StringRef(Typo);
    this.MaxEditDistance = $div_uint((Typo.size() + 2), 3);
    this.BestDecl = null;
    this.BestEditDistance = MaxEditDistance + 1;
    this.BestIndex = 0;
    this.NextIndex = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::SimpleTypoCorrector::addDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 983,
   FQN="clang::comments::(anonymous namespace)::SimpleTypoCorrector::addDecl", NM="_ZN5clang8comments12_GLOBAL__N_119SimpleTypoCorrector7addDeclEPKNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_119SimpleTypoCorrector7addDeclEPKNS_9NamedDeclE")
  //</editor-fold>
  public void addDecl(/*const*/ NamedDecl /*P*/ ND) {
    /*uint*/int CurrIndex = NextIndex++;
    
    /*const*/ IdentifierInfo /*P*/ II = ND.getIdentifier();
    if (!(II != null)) {
      return;
    }
    
    StringRef Name = II.getName();
    /*uint*/int MinPossibleEditDistance = abs((int)Name.size() - (int)Typo.size());
    if ($greater_uint(MinPossibleEditDistance, 0)
       && $less_uint($div_uint(Typo.size(), MinPossibleEditDistance), 3)) {
      return;
    }
    
    /*uint*/int EditDistance = Typo.edit_distance(/*NO_COPY*/Name, /*KEEP_BOOL*/true, MaxEditDistance);
    if ($less_uint(EditDistance, BestEditDistance)) {
      BestEditDistance = EditDistance;
      BestDecl = ND;
      BestIndex = CurrIndex;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::SimpleTypoCorrector::getBestDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 970,
   FQN="clang::comments::(anonymous namespace)::SimpleTypoCorrector::getBestDecl", NM="_ZNK5clang8comments12_GLOBAL__N_119SimpleTypoCorrector11getBestDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZNK5clang8comments12_GLOBAL__N_119SimpleTypoCorrector11getBestDeclEv")
  //</editor-fold>
  public /*const*/ NamedDecl /*P*/ getBestDecl() /*const*/ {
    if ($greater_uint(BestEditDistance, MaxEditDistance)) {
      return null;
    }
    
    return BestDecl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::SimpleTypoCorrector::getBestDeclIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp", line = 977,
   FQN="clang::comments::(anonymous namespace)::SimpleTypoCorrector::getBestDeclIndex", NM="_ZNK5clang8comments12_GLOBAL__N_119SimpleTypoCorrector16getBestDeclIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZNK5clang8comments12_GLOBAL__N_119SimpleTypoCorrector16getBestDeclIndexEv")
  //</editor-fold>
  public /*uint*/int getBestDeclIndex() /*const*/ {
    assert Native.$bool(getBestDecl());
    return BestIndex;
  }

  
  @Override public String toString() {
    return "" + "Typo=" + Typo // NOI18N
              + ", MaxEditDistance=" + MaxEditDistance // NOI18N
              + ", BestDecl=" + BestDecl // NOI18N
              + ", BestEditDistance=" + BestEditDistance // NOI18N
              + ", BestIndex=" + BestIndex // NOI18N
              + ", NextIndex=" + NextIndex; // NOI18N
  }
}
