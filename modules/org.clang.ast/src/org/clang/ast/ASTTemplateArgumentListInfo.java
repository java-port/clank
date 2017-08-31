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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clank.java.std;
import org.llvm.adt.java.TrailingObjectsUtils;


/// \brief Represents an explicit template argument list in C++, e.g.,
/// the "<int>" in "sort<int>".
/// This is safe to be used inside an AST node, in contrast with
/// TemplateArgumentListInfo.
//<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateArgumentListInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 572,
 FQN="clang::ASTTemplateArgumentListInfo", NM="_ZN5clang27ASTTemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang27ASTTemplateArgumentListInfoE")
//</editor-fold>
public final class/*struct*/ ASTTemplateArgumentListInfo extends TrailingObjectsJavaBase<ASTTemplateArgumentListInfo, TemplateArgumentLoc> implements /*private*/ TrailingObjects<ASTTemplateArgumentListInfo, TemplateArgumentLoc> {
/*private:*/
  /*friend  TrailingObjects<ASTTemplateArgumentListInfo, TemplateArgumentLoc>*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateArgumentListInfo::ASTTemplateArgumentListInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 537,
   FQN="clang::ASTTemplateArgumentListInfo::ASTTemplateArgumentListInfo", NM="_ZN5clang27ASTTemplateArgumentListInfoC1ERKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang27ASTTemplateArgumentListInfoC1ERKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  private ASTTemplateArgumentListInfo(final /*const*/ TemplateArgumentListInfo /*&*/ Info) {
    // : TrailingObjects<ASTTemplateArgumentListInfo, TemplateArgumentLoc>(), LAngleLoc(), RAngleLoc() 
    //START JInit
    $TrailingObjects();
    this.LAngleLoc = new SourceLocation();
    this.RAngleLoc = new SourceLocation();
    //END JInit
    LAngleLoc.$assignMove(Info.getLAngleLoc());
    RAngleLoc.$assignMove(Info.getRAngleLoc());
    NumTemplateArgs = Info.size();
    
    type$ptr<TemplateArgumentLoc/*P*/> ArgBuffer = $tryClone(getTrailingObjects(TemplateArgumentLoc.class));
    for (/*uint*/int i = 0; i != NumTemplateArgs; ++i)  {
      /*FIXME:NEW_EXPR[System]*/ArgBuffer.$set(i, /*new (&ArgBuffer[i])*/ new TemplateArgumentLoc(Info.$at$Const(i)));
    }
  }

/*public:*/
  /// \brief The source location of the left angle bracket ('<').
  public SourceLocation LAngleLoc;
  
  /// \brief The source location of the right angle bracket ('>').
  public SourceLocation RAngleLoc;
  
  /// \brief The number of template arguments in TemplateArgs.
  public /*uint*/int NumTemplateArgs;
  
  /// \brief Retrieve the template arguments
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateArgumentListInfo::getTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 591,
   FQN="clang::ASTTemplateArgumentListInfo::getTemplateArgs", NM="_ZNK5clang27ASTTemplateArgumentListInfo15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang27ASTTemplateArgumentListInfo15getTemplateArgsEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgumentLoc/*P*/> getTemplateArgs() /*const*/ {
    return getTrailingObjects$Const(TemplateArgumentLoc.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateArgumentListInfo::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateBase.h", line = 595,
   FQN="clang::ASTTemplateArgumentListInfo::operator[]", NM="_ZNK5clang27ASTTemplateArgumentListInfoixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZNK5clang27ASTTemplateArgumentListInfoixEj")
  //</editor-fold>
  public /*const*/ TemplateArgumentLoc /*&*/ $at(/*uint*/int I) /*const*/ {
    return getTemplateArgs().$at(I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTTemplateArgumentListInfo::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 529,
   FQN="clang::ASTTemplateArgumentListInfo::Create", NM="_ZN5clang27ASTTemplateArgumentListInfo6CreateERNS_10ASTContextERKNS_24TemplateArgumentListInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clang27ASTTemplateArgumentListInfo6CreateERNS_10ASTContextERKNS_24TemplateArgumentListInfoE")
  //</editor-fold>
  public static /*const*/ ASTTemplateArgumentListInfo /*P*/ Create(final ASTContext /*&*/ C, 
        final /*const*/ TemplateArgumentListInfo /*&*/ List) {
    /*uint*/int size = TrailingObjects.totalSizeToAlloc$Same(TemplateArgumentLoc.class, List.size());
    Object/*void P*/ Mem;
    if (false) {
      Mem = C.Allocate(size, alignOf(ASTTemplateArgumentListInfo.class));
    } else {
      Mem = C.Allocate$JavaRef(size, alignOf(ASTTemplateArgumentListInfo.class), 
              new std.pairIntPtr<>(1, ()->null), // for this
              new std.pairIntPtr<>(List.size(), ()->new TemplateArgumentLoc()));
    }
    return /*FIXME:NEW_EXPR[System]*//*new (Mem)*/ TrailingObjectsUtils.$new_uint_voidPtr(Mem, (type$ptr<?> _Mem)->
            new ASTTemplateArgumentListInfo(List)
    );
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public int getTrailingObjects$Offset(Class<?> clazz) {
    assert clazz == TemplateArgumentLoc.class;
    return 0;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "LAngleLoc=" + LAngleLoc // NOI18N
              + ", RAngleLoc=" + RAngleLoc // NOI18N
              + ", NumTemplateArgs=" + NumTemplateArgs // NOI18N
              + super.toString(); // NOI18N
  }
}
