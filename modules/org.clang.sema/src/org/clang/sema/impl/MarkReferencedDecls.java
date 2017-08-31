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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


// Mark all of the declarations referenced
// FIXME: Not fully implemented yet! We need to have a better understanding
// of when we're entering
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MarkReferencedDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14077,
 FQN="(anonymous namespace)::MarkReferencedDecls", NM="_ZN12_GLOBAL__N_119MarkReferencedDeclsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119MarkReferencedDeclsE")
//</editor-fold>
public class MarkReferencedDecls implements /*public*/ RecursiveASTVisitor<MarkReferencedDecls> {
  private final Sema /*&*/ S;
  private SourceLocation Loc;
/*public:*/
  /*typedef RecursiveASTVisitor<MarkReferencedDecls> Inherited*/
//  public final class Inherited extends RecursiveASTVisitor<MarkReferencedDecls>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MarkReferencedDecls::MarkReferencedDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14084,
   FQN="(anonymous namespace)::MarkReferencedDecls::MarkReferencedDecls", NM="_ZN12_GLOBAL__N_119MarkReferencedDeclsC1ERN5clang4SemaENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119MarkReferencedDeclsC1ERN5clang4SemaENS1_14SourceLocationE")
  //</editor-fold>
  public MarkReferencedDecls(final Sema /*&*/ S, SourceLocation Loc) {
    // : RecursiveASTVisitor<MarkReferencedDecls>(), S(S), Loc(Loc) 
    //START JInit
    $RecursiveASTVisitor();
    this./*&*/S=/*&*/S;
    this.Loc = new SourceLocation(Loc);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MarkReferencedDecls::TraverseTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14091,
   FQN="(anonymous namespace)::MarkReferencedDecls::TraverseTemplateArgument", NM="_ZN12_GLOBAL__N_119MarkReferencedDecls24TraverseTemplateArgumentERKN5clang16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119MarkReferencedDecls24TraverseTemplateArgumentERKN5clang16TemplateArgumentE")
  //</editor-fold>
  public boolean TraverseTemplateArgument(final /*const*/ TemplateArgument /*&*/ Arg) {
    if (Arg.getKind() == TemplateArgument.ArgKind.Declaration) {
      {
        Decl /*P*/ D = Arg.getAsDecl();
        if ((D != null)) {
          S.MarkAnyDeclReferenced(new SourceLocation(Loc), D, true);
        }
      }
    }
    
    return RecursiveASTVisitor.super.TraverseTemplateArgument(Arg);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MarkReferencedDecls::TraverseRecordType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14101,
   FQN="(anonymous namespace)::MarkReferencedDecls::TraverseRecordType", NM="_ZN12_GLOBAL__N_119MarkReferencedDecls18TraverseRecordTypeEPN5clang10RecordTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_119MarkReferencedDecls18TraverseRecordTypeEPN5clang10RecordTypeE")
  //</editor-fold>
  public boolean TraverseRecordType(RecordType /*P*/ T) {
    {
      ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(T.getDecl());
      if ((Spec != null)) {
        final /*const*/ TemplateArgumentList /*&*/ Args = Spec.getTemplateArgs();
        return TraverseTemplateArguments(Args.data(), Args.size());
      }
    }
    
    return true;
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Loc=" + Loc // NOI18N
              + super.toString(); // NOI18N
  }
}
