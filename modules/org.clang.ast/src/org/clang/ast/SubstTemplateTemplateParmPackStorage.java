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
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;


/// \brief A structure for storing an already-substituted template template
/// parameter pack.
///
/// This kind of template names occurs when the parameter pack has been 
/// provided with a template template argument pack in a context where its
/// enclosing pack expansion could not be fully expanded.
//<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTemplateParmPackStorage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 119,
 FQN="clang::SubstTemplateTemplateParmPackStorage", NM="_ZN5clang36SubstTemplateTemplateParmPackStorageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang36SubstTemplateTemplateParmPackStorageE")
//</editor-fold>
public class SubstTemplateTemplateParmPackStorage extends /*public*/ UncommonTemplateNameStorage implements /*public*/ FoldingSetImpl.ContextualNode<ASTContext> {
  private TemplateTemplateParmDecl /*P*/ Parameter;
  private /*const*/type$ptr<TemplateArgument/*P*/> Arguments;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTemplateParmPackStorage::SubstTemplateTemplateParmPackStorage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 126,
   FQN="clang::SubstTemplateTemplateParmPackStorage::SubstTemplateTemplateParmPackStorage", NM="_ZN5clang36SubstTemplateTemplateParmPackStorageC1EPNS_24TemplateTemplateParmDeclEjPKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang36SubstTemplateTemplateParmPackStorageC1EPNS_24TemplateTemplateParmDeclEjPKNS_16TemplateArgumentE")
  //</editor-fold>
  public SubstTemplateTemplateParmPackStorage(TemplateTemplateParmDecl /*P*/ Parameter, 
      /*uint*/int Size, 
      /*const*/type$ptr<TemplateArgument/*P*/> Arguments) {
    // : UncommonTemplateNameStorage(SubstTemplateTemplateParmPack, Size), FoldingSetNode(), Parameter(Parameter), Arguments(Arguments) 
    //START JInit
    super(Kind.SubstTemplateTemplateParmPack, Size);
    $Node();
    this.Parameter = Parameter;
    this.Arguments = $tryClone(Arguments);
    //END JInit
  }

  
  /// \brief Retrieve the template template parameter pack being substituted.
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTemplateParmPackStorage::getParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 133,
   FQN="clang::SubstTemplateTemplateParmPackStorage::getParameterPack", NM="_ZNK5clang36SubstTemplateTemplateParmPackStorage16getParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang36SubstTemplateTemplateParmPackStorage16getParameterPackEv")
  //</editor-fold>
  public TemplateTemplateParmDecl /*P*/ getParameterPack() /*const*/ {
    return Parameter;
  }

  
  /// \brief Retrieve the template template argument pack with which this
  /// parameter was substituted.
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTemplateParmPackStorage::getArgumentPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 25,
   FQN="clang::SubstTemplateTemplateParmPackStorage::getArgumentPack", NM="_ZNK5clang36SubstTemplateTemplateParmPackStorage15getArgumentPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang36SubstTemplateTemplateParmPackStorage15getArgumentPackEv")
  //</editor-fold>
  public TemplateArgument getArgumentPack() /*const*/ {
    return new TemplateArgument(llvm.makeArrayRef(Arguments, size()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTemplateParmPackStorage::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 41,
   FQN="clang::SubstTemplateTemplateParmPackStorage::Profile", NM="_ZN5clang36SubstTemplateTemplateParmPackStorage7ProfileERN4llvm16FoldingSetNodeIDERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang36SubstTemplateTemplateParmPackStorage7ProfileERN4llvm16FoldingSetNodeIDERNS_10ASTContextE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID, 
         final ASTContext /*&*/ Context) {
    Profile(ID, Context, Parameter, getArgumentPack());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::SubstTemplateTemplateParmPackStorage::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 46,
   FQN="clang::SubstTemplateTemplateParmPackStorage::Profile", NM="_ZN5clang36SubstTemplateTemplateParmPackStorage7ProfileERN4llvm16FoldingSetNodeIDERNS_10ASTContextEPNS_24TemplateTemplateParmDeclERKNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang36SubstTemplateTemplateParmPackStorage7ProfileERN4llvm16FoldingSetNodeIDERNS_10ASTContextEPNS_24TemplateTemplateParmDeclERKNS_16TemplateArgumentE")
  //</editor-fold>
  public static void Profile(final FoldingSetNodeID /*&*/ ID, 
         final ASTContext /*&*/ Context, 
         TemplateTemplateParmDecl /*P*/ Parameter, 
         final /*const*/ TemplateArgument /*&*/ ArgPack) {
    ID.AddPointer(Parameter);
    ArgPack.Profile(ID, Context);
  }

  
  @Override public String toString() {
    return "" + "Parameter=" + Parameter // NOI18N
              + ", Arguments=" + Arguments // NOI18N
              + super.toString(); // NOI18N
  }
}
