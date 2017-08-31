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
package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.impl.ASTDiagnosticStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type ASTDiagnosticClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang31FormatASTNodeDiagnosticArgumentENS_17DiagnosticsEngine12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEE; -static-type=ASTDiagnosticClangGlobals -package=org.clang.ast.impl")
//</editor-fold>
public final class ASTDiagnosticClangGlobals {

// end namespace diag

/// \brief DiagnosticsEngine argument formatting function for diagnostics that
/// involve AST nodes.
///
/// This function formats diagnostic arguments for various AST nodes, 
/// including types, declaration names, nested name specifiers, and
/// declaration contexts, into strings that can be printed as part of
/// diagnostics. It is meant to be used as the argument to
/// \c DiagnosticsEngine::SetArgToStringFn(), where the cookie is an \c
/// ASTContext pointer.
//<editor-fold defaultstate="collapsed" desc="clang::FormatASTNodeDiagnosticArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 321,
 FQN="clang::FormatASTNodeDiagnosticArgument", NM="_ZN5clang31FormatASTNodeDiagnosticArgumentENS_17DiagnosticsEngine12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang31FormatASTNodeDiagnosticArgumentENS_17DiagnosticsEngine12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEE")
//</editor-fold>
public static void FormatASTNodeDiagnosticArgument(DiagnosticsEngine.ArgumentKind Kind, 
                               Object/*intptr_t*/ Val, 
                               StringRef Modifier, 
                               StringRef Argument, 
                               ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>> PrevArgs, 
                               final SmallString/*&*/ Output, 
                               Object/*void P*/ Cookie, 
                               ArrayRef<Object/*intptr_t*/> QualTypeVals) {
  raw_svector_ostream OS = null;
  try {
    final ASTContext /*&*/ Context = $Deref(((/*static_cast*/ASTContext /*P*/ )(Cookie)));
    
    /*size_t*/int OldEnd = Output.size();
    OS/*J*/= new raw_svector_ostream(Output);
    boolean NeedQuotes = true;
    switch (Kind) {
     default:
      throw new llvm_unreachable("unknown ArgumentKind");
     case ak_qualtype_pair:
      {
        final TemplateDiffTypes /*&*/ TDT = $Deref(reinterpret_cast(TemplateDiffTypes /*P*/ .class, Val));
        QualType FromType = QualType.getFromOpaquePtr(reinterpret_cast(Object/*void P*/ .class, TDT.FromType));
        QualType ToType = QualType.getFromOpaquePtr(reinterpret_cast(Object/*void P*/ .class, TDT.ToType));
        if (FormatTemplateTypeDiff(Context, new QualType(FromType), new QualType(ToType), TDT.PrintTree, 
            TDT.PrintFromType, TDT.ElideType, 
            TDT.ShowColors, OS)) {
          NeedQuotes = !TDT.PrintTree;
          TDT.TemplateDiffUsed = true;
          break;
        }
        
        // Don't fall-back during tree printing.  The caller will handle
        // this case.
        if (TDT.PrintTree) {
          return;
        }
        
        // Attempting to do a template diff on non-templates.  Set the variables
        // and continue with regular type printing of the appropriate type.
        Val = TDT.PrintFromType ? TDT.FromType : TDT.ToType;
        Modifier.$assignMove(new StringRef());
        Argument.$assignMove(new StringRef());
        // Fall through
      }
     case ak_qualtype:
      {
        assert (Modifier.empty() && Argument.empty()) : "Invalid modifier for QualType argument";
        
        QualType Ty/*J*/= QualType.getFromOpaquePtr(reinterpret_cast(Object/*void P*/ .class, Val));
        OS.$out(ConvertTypeToDiagnosticString(Context, new QualType(Ty), new ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>>(PrevArgs), new ArrayRef<Object/*intptr_t*/>(QualTypeVals)));
        NeedQuotes = false;
        break;
      }
     case ak_declarationname:
      {
        if ($eq_StringRef(/*NO_COPY*/Modifier, /*STRINGREF_STR*/"objcclass") && Argument.empty()) {
          OS.$out_char($$PLUS);
        } else if ($eq_StringRef(/*NO_COPY*/Modifier, /*STRINGREF_STR*/"objcinstance") && Argument.empty()) {
          OS.$out_char($$MINUS);
        } else {
          assert (Modifier.empty() && Argument.empty()) : "Invalid modifier for DeclarationName argument";
        }
        
        $out_raw_ostream_DeclarationName(OS, DeclarationName.getFromOpaqueInteger(Val));
        break;
      }
     case ak_nameddecl:
      {
        boolean Qualified;
        if ($eq_StringRef(/*NO_COPY*/Modifier, /*STRINGREF_STR*/"q") && Argument.empty()) {
          Qualified = true;
        } else {
          assert (Modifier.empty() && Argument.empty()) : "Invalid modifier for NamedDecl* argument";
          Qualified = false;
        }
        /*const*/ NamedDecl /*P*/ ND = reinterpret_cast(/*const*/ NamedDecl /*P*/ .class, Val);
        ND.getNameForDiagnostic(OS, Context.getPrintingPolicy(), Qualified);
        break;
      }
     case ak_nestednamespec:
      {
        NestedNameSpecifier /*P*/ NNS = reinterpret_cast(NestedNameSpecifier /*P*/ .class, Val);
        NNS.print(OS, Context.getPrintingPolicy());
        NeedQuotes = false;
        break;
      }
     case ak_declcontext:
      {
        DeclContext /*P*/ DC = reinterpret_cast(DeclContext /*P*/ .class, Val);
        assert ((DC != null)) : "Should never have a null declaration context";
        NeedQuotes = false;
        
        // FIXME: Get the strings for DeclContext from some localized place
        if (DC.isTranslationUnit()) {
          if (Context.getLangOpts().CPlusPlus) {
            OS.$out(/*KEEP_STR*/"the global namespace");
          } else {
            OS.$out(/*KEEP_STR*/"the global scope");
          }
        } else if (DC.isClosure()) {
          OS.$out(/*KEEP_STR*/"block literal");
        } else if (isLambdaCallOperator(DC)) {
          OS.$out(/*KEEP_STR*/"lambda expression");
        } else {
          TypeDecl /*P*/ Type = dyn_cast_TypeDecl(DC);
          if ((Type != null)) {
            OS.$out(ConvertTypeToDiagnosticString(Context, 
                    Context.getTypeDeclType(Type), 
                    new ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>>(PrevArgs), new ArrayRef<Object/*intptr_t*/>(QualTypeVals)));
          } else {
            assert (isa_NamedDecl(DC)) : "Expected a NamedDecl";
            NamedDecl /*P*/ ND = cast_NamedDecl(DC);
            if (isa_NamespaceDecl(ND)) {
              OS.$out(/*KEEP_STR*/"namespace ");
            } else if (isa_ObjCMethodDecl(ND)) {
              OS.$out(/*KEEP_STR*/"method ");
            } else if (isa_FunctionDecl(ND)) {
              OS.$out(/*KEEP_STR*/"function ");
            }
            
            OS.$out_char($$SGL_QUOTE);
            ND.getNameForDiagnostic(OS, Context.getPrintingPolicy(), true);
            OS.$out_char($$SGL_QUOTE);
          }
        }
        break;
      }
     case ak_attr:
      {
        /*const*/ Attr /*P*/ At = reinterpret_cast(Attr /*P*/ .class, Val);
        assert ((At != null)) : "Received null Attr object!";
        OS.$out_char($$SGL_QUOTE).$out(At.getSpelling()).$out_char($$SGL_QUOTE);
        NeedQuotes = false;
        break;
      }
    }
    if (NeedQuotes) {
      Output.insert(Output.begin().$add(OldEnd), $$SGL_QUOTE);
      Output.push_back($$SGL_QUOTE);
    }
  } finally {
    if (OS != null) { OS.$destroy(); }
  }
}

} // END OF class ASTDiagnosticClangGlobals
