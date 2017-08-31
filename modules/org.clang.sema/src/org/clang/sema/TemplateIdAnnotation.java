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

package org.clang.sema;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// \brief Information about a template-id annotation
/// token.
///
/// A template-id annotation token contains the template declaration, 
/// template arguments, whether those template arguments were types, 
/// expressions, or template names, and the source locations for important 
/// tokens. All of the information about template arguments is allocated 
/// directly after this structure.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateIdAnnotation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 148,
 FQN="clang::TemplateIdAnnotation", NM="_ZN5clang20TemplateIdAnnotationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang20TemplateIdAnnotationE")
//</editor-fold>
public class/*struct*/ TemplateIdAnnotation implements Destructors.ClassWithDestructor {
  /// \brief The nested-name-specifier that precedes the template name.
  public CXXScopeSpec SS;
  
  /// TemplateKWLoc - The location of the template keyword within the
  /// source.
  public SourceLocation TemplateKWLoc;
  
  /// TemplateNameLoc - The location of the template name within the
  /// source.
  public SourceLocation TemplateNameLoc;
  
  /// FIXME: Temporarily stores the name of a specialization
  public IdentifierInfo /*P*/ Name;
  
  /// FIXME: Temporarily stores the overloaded operator kind.
  public OverloadedOperatorKind Operator;
  
  /// The declaration of the template corresponding to the
  /// template-name.
  public OpaquePtr<TemplateName> Template;
  
  /// The kind of template that Template refers to.
  public TemplateNameKind Kind;
  
  /// The location of the '<' before the template argument
  /// list.
  public SourceLocation LAngleLoc;
  
  /// The location of the '>' after the template argument
  /// list.
  public SourceLocation RAngleLoc;
  
  /// NumArgs - The number of template arguments.
  public /*uint*/int NumArgs;
  
  /// \brief Retrieves a pointer to the template arguments
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateIdAnnotation::getTemplateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 185,
   FQN="clang::TemplateIdAnnotation::getTemplateArgs", NM="_ZN5clang20TemplateIdAnnotation15getTemplateArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang20TemplateIdAnnotation15getTemplateArgsEv")
  //</editor-fold>
  public type$ptr<ParsedTemplateArgument> /*P*/ getTemplateArgs() {
    return create_type$ptr(parsedTemplateArguments);
  }

  
  /// \brief Creates a new TemplateIdAnnotation with NumArgs arguments and
  /// appends it to List.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateIdAnnotation::Allocate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 191,
   FQN="clang::TemplateIdAnnotation::Allocate", NM="_ZN5clang20TemplateIdAnnotation8AllocateEjRN4llvm15SmallVectorImplIPS0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang20TemplateIdAnnotation8AllocateEjRN4llvm15SmallVectorImplIPS0_EE")
  //</editor-fold>
  public static TemplateIdAnnotation /*P*/ Allocate(/*uint*/int NumArgs, final SmallVectorImpl<TemplateIdAnnotation /*P*/ > /*&*/ List) {
    TemplateIdAnnotation /*P*/ TemplateId = new TemplateIdAnnotation(); //JAVA: (TemplateIdAnnotation /*P*/ )std.malloc($sizeof_TemplateIdAnnotation()
           //JAVA: + $sizeof_ParsedTemplateArgument() * NumArgs);
    TemplateId.NumArgs = NumArgs;
    
    // Default-construct nested-name-specifier.
    /*FIXME:NEW_EXPR*//*AddrOf*/TemplateId.SS = /*new (&TemplateId->SS)*/ new CXXScopeSpec();
    
    // Default-construct parsed template arguments.
    TemplateId.parsedTemplateArguments = new ParsedTemplateArgument[NumArgs]; //JAVA: ParsedTemplateArgument /*P*/ TemplateArgs = TemplateId.getTemplateArgs();
    for (/*uint*/int I = 0; I != NumArgs; ++I)  {
      TemplateId.parsedTemplateArguments[I] = /*FIXME:NEW_EXPR*/ /*TemplateArgs + I = new (TemplateArgs + I)*/ new ParsedTemplateArgument();
    }
    
    List.push_back(TemplateId);
    return TemplateId;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateIdAnnotation::Destroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/ParsedTemplate.h", line = 210,
   FQN="clang::TemplateIdAnnotation::Destroy", NM="_ZN5clang20TemplateIdAnnotation7DestroyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseTemplate.cpp -nm=_ZN5clang20TemplateIdAnnotation7DestroyEv")
  //</editor-fold>
  public void Destroy() {
    SS.$destroy();
    free(this);
  }

  @Converted(kind = Converted.Kind.DUMMY)
  @Override
  public void $destroy() {
    SS.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  ParsedTemplateArgument[] parsedTemplateArguments; // this+1
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public TemplateIdAnnotation() {
    this.SS = new CXXScopeSpec();
    this.TemplateKWLoc = new SourceLocation();
    this.TemplateNameLoc = new SourceLocation();
    this.Operator = OverloadedOperatorKind.OO_None;
    this.Template = new OpaquePtr<>();
    this.Kind = TemplateNameKind.TNK_Non_template;
    this.LAngleLoc = new SourceLocation();
    this.RAngleLoc = new SourceLocation();
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "SS=" + SS // NOI18N
              + ", TemplateKWLoc=" + TemplateKWLoc // NOI18N
              + ", TemplateNameLoc=" + TemplateNameLoc // NOI18N
              + ", Name=" + Name // NOI18N
              + ", Operator=" + Operator // NOI18N
              + ", Template=" + Template // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", LAngleLoc=" + LAngleLoc // NOI18N
              + ", RAngleLoc=" + RAngleLoc // NOI18N
              + ", NumArgs=" + NumArgs; // NOI18N
  }
}
