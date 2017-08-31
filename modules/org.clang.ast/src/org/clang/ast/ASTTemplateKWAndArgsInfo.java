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
import org.clang.basic.*;


/// \brief Represents an explicit template argument list in C++, e.g.,
/// the "<int>" in "sort<int>".
///
/// It is intended to be used as a trailing object on AST nodes, and
/// as such, doesn't contain the array of TemplateArgumentLoc itself,
/// but expects the containing object to also provide storage for
/// that.
//<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateKWAndArgsInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 610,
 FQN="clang::ASTTemplateKWAndArgsInfo", NM="_ZN5clang24ASTTemplateKWAndArgsInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang24ASTTemplateKWAndArgsInfoE")
//</editor-fold>
public class/*struct*/ ASTTemplateKWAndArgsInfo {
  /// \brief The source location of the left angle bracket ('<').
  public SourceLocation LAngleLoc;
  
  /// \brief The source location of the right angle bracket ('>').
  public SourceLocation RAngleLoc;
  
  /// \brief The source location of the template keyword; this is used
  /// as part of the representation of qualified identifiers, such as
  /// S<T>::template apply<T>.  Will be empty if this expression does
  /// not have a template keyword.
  public SourceLocation TemplateKWLoc;
  
  /// \brief The number of template arguments in TemplateArgs.
  public /*uint*/int NumTemplateArgs;
    
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateKWAndArgsInfo::initializeFrom">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 548,
   FQN="clang::ASTTemplateKWAndArgsInfo::initializeFrom", NM="_ZN5clang24ASTTemplateKWAndArgsInfo14initializeFromENS_14SourceLocationERKNS_24TemplateArgumentListInfoEPNS_19TemplateArgumentLocE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang24ASTTemplateKWAndArgsInfo14initializeFromENS_14SourceLocationERKNS_24TemplateArgumentListInfoEPNS_19TemplateArgumentLocE")
  //</editor-fold>
  public void initializeFrom(SourceLocation TemplateKWLoc, final /*const*/ TemplateArgumentListInfo /*&*/ Info, 
                type$ptr<TemplateArgumentLoc/*P*/> OutArgArray) {
    this.TemplateKWLoc.$assign(TemplateKWLoc);
    LAngleLoc.$assignMove(Info.getLAngleLoc());
    RAngleLoc.$assignMove(Info.getRAngleLoc());
    NumTemplateArgs = Info.size();
    
    for (/*uint*/int i = 0; i != NumTemplateArgs; ++i)  {
      /*FIXME:NEW_EXPR[System]*/OutArgArray.$set(i, /*new (&OutArgArray[i])*/ new TemplateArgumentLoc(Info.$at$Const(i)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateKWAndArgsInfo::initializeFrom">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 568,
   FQN="clang::ASTTemplateKWAndArgsInfo::initializeFrom", NM="_ZN5clang24ASTTemplateKWAndArgsInfo14initializeFromENS_14SourceLocationERKNS_24TemplateArgumentListInfoEPNS_19TemplateArgumentLocERbS7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang24ASTTemplateKWAndArgsInfo14initializeFromENS_14SourceLocationERKNS_24TemplateArgumentListInfoEPNS_19TemplateArgumentLocERbS7_S7_")
  //</editor-fold>
  public void initializeFrom(SourceLocation TemplateKWLoc, final /*const*/ TemplateArgumentListInfo /*&*/ Info, 
                type$ptr<TemplateArgumentLoc/*P*/> OutArgArray, final bool$ref/*bool &*/ Dependent, 
                final bool$ref/*bool &*/ InstantiationDependent, final bool$ref/*bool &*/ ContainsUnexpandedParameterPack) {
    this.TemplateKWLoc.$assign(TemplateKWLoc);
    LAngleLoc.$assignMove(Info.getLAngleLoc());
    RAngleLoc.$assignMove(Info.getRAngleLoc());
    NumTemplateArgs = Info.size();
    
    for (/*uint*/int i = 0; i != NumTemplateArgs; ++i) {
      Dependent.$set(Dependent.$deref() || Info.$at$Const(i).getArgument().isDependent());
      InstantiationDependent.$set(InstantiationDependent.$deref()
         || Info.$at$Const(i).getArgument().isInstantiationDependent());
      ContainsUnexpandedParameterPack.$set(ContainsUnexpandedParameterPack.$deref()
         || Info.$at$Const(i).getArgument().containsUnexpandedParameterPack());
      
      /*FIXME:NEW_EXPR[System]*/OutArgArray.$set(i, /*new (&OutArgArray[i])*/ new TemplateArgumentLoc(Info.$at$Const(i)));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateKWAndArgsInfo::initializeFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 560,
   FQN="clang::ASTTemplateKWAndArgsInfo::initializeFrom", NM="_ZN5clang24ASTTemplateKWAndArgsInfo14initializeFromENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang24ASTTemplateKWAndArgsInfo14initializeFromENS_14SourceLocationE")
  //</editor-fold>
  public void initializeFrom(SourceLocation TemplateKWLoc) {
    assert (TemplateKWLoc.isValid());
    LAngleLoc.$assignMove(new SourceLocation());
    RAngleLoc.$assignMove(new SourceLocation());
    this.TemplateKWLoc.$assign(TemplateKWLoc);
    NumTemplateArgs = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateKWAndArgsInfo::copyInto">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 589,
   FQN="clang::ASTTemplateKWAndArgsInfo::copyInto", NM="_ZNK5clang24ASTTemplateKWAndArgsInfo8copyIntoEPKNS_19TemplateArgumentLocERNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang24ASTTemplateKWAndArgsInfo8copyIntoEPKNS_19TemplateArgumentLocERNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public void copyInto(/*const*/type$ptr<TemplateArgumentLoc/*P*/> ArgArray, 
          final TemplateArgumentListInfo /*&*/ Info) /*const*/ {
    Info.setLAngleLoc(new SourceLocation(LAngleLoc));
    Info.setRAngleLoc(new SourceLocation(RAngleLoc));
    for (/*uint*/int I = 0; I != NumTemplateArgs; ++I)  {
      Info.addArgument(ArgArray.$at(I));
    }
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public ASTTemplateKWAndArgsInfo() {
    this.LAngleLoc = new SourceLocation();
    this.RAngleLoc = new SourceLocation();
    this.TemplateKWLoc = new SourceLocation();
    this.NumTemplateArgs = 0;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "LAngleLoc=" + LAngleLoc // NOI18N
              + ", RAngleLoc=" + RAngleLoc // NOI18N
              + ", TemplateKWLoc=" + TemplateKWLoc // NOI18N
              + ", NumTemplateArgs=" + NumTemplateArgs; // NOI18N
  }
}
