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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clank.support.Native.NativePOD;


/// A convenient class for passing around template argument
/// information.  Designed to be passed by reference.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 523,
 FQN="clang::TemplateArgumentListInfo", NM="_ZN5clang24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfoE")
//</editor-fold>
public class TemplateArgumentListInfo implements Destructors.ClassWithDestructor, NativePOD<TemplateArgumentListInfo> {
  private SmallVector<TemplateArgumentLoc> Arguments;
  private SourceLocation LAngleLoc;
  private SourceLocation RAngleLoc;
  
  // This can leak if used in an AST node, use ASTTemplateArgumentListInfo
  // instead.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 530,
   FQN="clang::TemplateArgumentListInfo::operator new", NM="_ZN5clang24TemplateArgumentListInfonwEjRNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfonwEjRNS_10ASTContextE")
  //</editor-fold>
  private static Object/*void P*/ $new(/*size_t*/int bytes, final ASTContext /*&*/ C) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::TemplateArgumentListInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 533,
   FQN="clang::TemplateArgumentListInfo::TemplateArgumentListInfo", NM="_ZN5clang24TemplateArgumentListInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfoC1Ev")
  //</editor-fold>
  public TemplateArgumentListInfo() {
    // : Arguments(), LAngleLoc(), RAngleLoc() 
    //START JInit
    this.Arguments = new SmallVector<TemplateArgumentLoc>(8, new TemplateArgumentLoc());
    this.LAngleLoc = new SourceLocation();
    this.RAngleLoc = new SourceLocation();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::TemplateArgumentListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 535,
   FQN="clang::TemplateArgumentListInfo::TemplateArgumentListInfo", NM="_ZN5clang24TemplateArgumentListInfoC1ENS_14SourceLocationES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfoC1ENS_14SourceLocationES1_")
  //</editor-fold>
  public TemplateArgumentListInfo(SourceLocation LAngleLoc, 
      SourceLocation RAngleLoc) {
    // : Arguments(), LAngleLoc(LAngleLoc), RAngleLoc(RAngleLoc) 
    //START JInit
    this.Arguments = new SmallVector<TemplateArgumentLoc>(8, new TemplateArgumentLoc());
    this.LAngleLoc = new SourceLocation(LAngleLoc);
    this.RAngleLoc = new SourceLocation(RAngleLoc);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::getLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 539,
   FQN="clang::TemplateArgumentListInfo::getLAngleLoc", NM="_ZNK5clang24TemplateArgumentListInfo12getLAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang24TemplateArgumentListInfo12getLAngleLocEv")
  //</editor-fold>
  public SourceLocation getLAngleLoc() /*const*/ {
    return new SourceLocation(LAngleLoc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::getRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 540,
   FQN="clang::TemplateArgumentListInfo::getRAngleLoc", NM="_ZNK5clang24TemplateArgumentListInfo12getRAngleLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang24TemplateArgumentListInfo12getRAngleLocEv")
  //</editor-fold>
  public SourceLocation getRAngleLoc() /*const*/ {
    return new SourceLocation(RAngleLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::setLAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 542,
   FQN="clang::TemplateArgumentListInfo::setLAngleLoc", NM="_ZN5clang24TemplateArgumentListInfo12setLAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfo12setLAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setLAngleLoc(SourceLocation Loc) {
    LAngleLoc.$assign(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::setRAngleLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 543,
   FQN="clang::TemplateArgumentListInfo::setRAngleLoc", NM="_ZN5clang24TemplateArgumentListInfo12setRAngleLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfo12setRAngleLocENS_14SourceLocationE")
  //</editor-fold>
  public void setRAngleLoc(SourceLocation Loc) {
    RAngleLoc.$assign(Loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 545,
   FQN="clang::TemplateArgumentListInfo::size", NM="_ZNK5clang24TemplateArgumentListInfo4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang24TemplateArgumentListInfo4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Arguments.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::getArgumentArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 547,
   FQN="clang::TemplateArgumentListInfo::getArgumentArray", NM="_ZNK5clang24TemplateArgumentListInfo16getArgumentArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang24TemplateArgumentListInfo16getArgumentArrayEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgumentLoc/*P*/> getArgumentArray() /*const*/ {
    return Arguments.data$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::arguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 551,
   FQN="clang::TemplateArgumentListInfo::arguments", NM="_ZNK5clang24TemplateArgumentListInfo9argumentsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang24TemplateArgumentListInfo9argumentsEv")
  //</editor-fold>
  public ArrayRef<TemplateArgumentLoc> arguments() /*const*/ {
    return new ArrayRef<TemplateArgumentLoc>(Arguments, false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 555,
   FQN="clang::TemplateArgumentListInfo::operator[]", NM="_ZNK5clang24TemplateArgumentListInfoixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZNK5clang24TemplateArgumentListInfoixEj")
  //</editor-fold>
  public /*const*/ TemplateArgumentLoc /*&*/ $at$Const(/*uint*/int I) /*const*/ {
    return Arguments.$at$Const(I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 559,
   FQN="clang::TemplateArgumentListInfo::operator[]", NM="_ZN5clang24TemplateArgumentListInfoixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfoixEj")
  //</editor-fold>
  public TemplateArgumentLoc /*&*/ $at(/*uint*/int I) {
    return Arguments.$at(I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::addArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 563,
   FQN="clang::TemplateArgumentListInfo::addArgument", NM="_ZN5clang24TemplateArgumentListInfo11addArgumentERKNS_19TemplateArgumentLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfo11addArgumentERKNS_19TemplateArgumentLocE")
  //</editor-fold>
  public void addArgument(final /*const*/ TemplateArgumentLoc /*&*/ Loc) {
    Arguments.push_back(Loc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::TemplateArgumentListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 523,
   FQN="clang::TemplateArgumentListInfo::TemplateArgumentListInfo", NM="_ZN5clang24TemplateArgumentListInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentListInfo(JD$Move _dparam, final TemplateArgumentListInfo /*&&*/$Prm0) {
    // : Arguments(static_cast<TemplateArgumentListInfo &&>().Arguments), LAngleLoc(static_cast<TemplateArgumentListInfo &&>().LAngleLoc), RAngleLoc(static_cast<TemplateArgumentListInfo &&>().RAngleLoc) 
    //START JInit
    this.Arguments = new SmallVector<TemplateArgumentLoc>(JD$Move.INSTANCE, $Prm0.Arguments);
    this.LAngleLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.LAngleLoc);
    this.RAngleLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.RAngleLoc);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 523,
   FQN="clang::TemplateArgumentListInfo::operator=", NM="_ZN5clang24TemplateArgumentListInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentListInfo /*&*/ $assignMove(final TemplateArgumentListInfo /*&&*/$Prm0) {
    this.Arguments.$assignMove($Prm0.Arguments);
    this.LAngleLoc.$assignMove($Prm0.LAngleLoc);
    this.RAngleLoc.$assignMove($Prm0.RAngleLoc);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::TemplateArgumentListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 523,
   FQN="clang::TemplateArgumentListInfo::TemplateArgumentListInfo", NM="_ZN5clang24TemplateArgumentListInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentListInfo(final /*const*/ TemplateArgumentListInfo /*&*/ $Prm0) {
    // : Arguments(.Arguments), LAngleLoc(.LAngleLoc), RAngleLoc(.RAngleLoc) 
    //START JInit
    this.Arguments = new SmallVector<TemplateArgumentLoc>($Prm0.Arguments);
    this.LAngleLoc = new SourceLocation($Prm0.LAngleLoc);
    this.RAngleLoc = new SourceLocation($Prm0.RAngleLoc);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::~TemplateArgumentListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 523,
   FQN="clang::TemplateArgumentListInfo::~TemplateArgumentListInfo", NM="_ZN5clang24TemplateArgumentListInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Arguments.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentListInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 523,
   FQN="clang::TemplateArgumentListInfo::operator=", NM="_ZN5clang24TemplateArgumentListInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang24TemplateArgumentListInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateArgumentListInfo /*&*/ $assign(final /*const*/ TemplateArgumentListInfo /*&*/ $Prm0) {
    this.Arguments.$assign($Prm0.Arguments);
    this.LAngleLoc.$assign($Prm0.LAngleLoc);
    this.RAngleLoc.$assign($Prm0.RAngleLoc);
    return /*Deref*/this;
  }

  @Override public TemplateArgumentListInfo clone() { return new TemplateArgumentListInfo(this); }
  
  @Override public String toString() {
    return "" + "Arguments=" + Arguments // NOI18N
              + ", LAngleLoc=" + LAngleLoc // NOI18N
              + ", RAngleLoc=" + RAngleLoc; // NOI18N
  }
}
