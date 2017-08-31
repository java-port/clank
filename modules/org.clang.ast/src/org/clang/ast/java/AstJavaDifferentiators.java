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

package org.clang.ast.java;

/**
 *
 * @author vv159170
 */
public interface AstJavaDifferentiators {
  
  public static final class JD$SameQualTypeAndType {
    public static final JD$SameQualTypeAndType INSTANCE = new JD$SameQualTypeAndType();
    private JD$SameQualTypeAndType() {}
  }  
  
  public static final class JD$CXXConstructorDecl$C$P_CXXCtorType {
    public static final JD$CXXConstructorDecl$C$P_CXXCtorType INSTANCE = new JD$CXXConstructorDecl$C$P_CXXCtorType();
    private JD$CXXConstructorDecl$C$P_CXXCtorType() {}
  }  
  
  public static final class JD$CXXDestructorDecl$C$P_CXXDtorType {
    public static final JD$CXXDestructorDecl$C$P_CXXDtorType INSTANCE = new JD$CXXDestructorDecl$C$P_CXXDtorType();
    private JD$CXXDestructorDecl$C$P_CXXDtorType() {}
  }  
  
  public static final class JD$QualType_ExprValueKind_SourceLocation_TypeSourceInfo$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool {
    public static final JD$QualType_ExprValueKind_SourceLocation_TypeSourceInfo$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool INSTANCE = new JD$QualType_ExprValueKind_SourceLocation_TypeSourceInfo$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool();
    private JD$QualType_ExprValueKind_SourceLocation_TypeSourceInfo$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool() {}
  }  
  
  public static final class JD$QualType_ExprValueKind_SourceLocation_Expr$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool {
    public static final JD$QualType_ExprValueKind_SourceLocation_Expr$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool INSTANCE = new JD$QualType_ExprValueKind_SourceLocation_Expr$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool();
    private JD$QualType_ExprValueKind_SourceLocation_Expr$P_Selector_ArrayRef$SourceLocation_SelectorLocationsKind_ObjCMethodDecl$P_ArrayRef$Expr$P_SourceLocation_Bool() {}
  }  
  
  public static final class JD$DeclAccessPair$P {
    public static final JD$DeclAccessPair$P INSTANCE = new JD$DeclAccessPair$P();
    private JD$DeclAccessPair$P() {}
  }  
  
  public static final class JD$DeclAccessPair$C$P {
    public static final JD$DeclAccessPair$C$P INSTANCE = new JD$DeclAccessPair$C$P();
    private JD$DeclAccessPair$C$P() {}
  }  
  
  public static final class JD$TemplateArgumentList$C$P {
    public static final JD$TemplateArgumentList$C$P INSTANCE = new JD$TemplateArgumentList$C$P();
    private JD$TemplateArgumentList$C$P() {}
  }  
  
  public static final class JD$LatestTag_ASTContext$C {
    public static final JD$LatestTag_ASTContext$C INSTANCE = new JD$LatestTag_ASTContext$C();
    private JD$LatestTag_ASTContext$C() {}
  }  
  
  public static final class JD$PreviousTag_T$P {
    public static final JD$PreviousTag_T$P INSTANCE = new JD$PreviousTag_T$P();
    private JD$PreviousTag_T$P() {}
  }  
  
  public static final class JD$MicrosoftMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType {
    public static final JD$MicrosoftMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType INSTANCE = new JD$MicrosoftMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType();
    private JD$MicrosoftMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType() {}
  }    
  
  public static final class JD$MicrosoftMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType {
    public static final JD$MicrosoftMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType INSTANCE = new JD$MicrosoftMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType();
    private JD$MicrosoftMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType() {}
  }

  public static final class JD$ItaniumMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType {
    public static final JD$ItaniumMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType INSTANCE = new JD$ItaniumMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType();
    private JD$ItaniumMangleContextImpl_Raw_ostream_CXXDestructorDecl$C$P_CXXDtorType() {}
  }

  public static final class JD$ItaniumMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType {
    public static final JD$ItaniumMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType INSTANCE = new JD$ItaniumMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType();
    private JD$ItaniumMangleContextImpl_Raw_ostream_CXXConstructorDecl$C$P_CXXCtorType() {}
  }  

  public static final class JD$Type$ref$AbiTagState$P {
    public static final JD$Type$ref$AbiTagState$P INSTANCE = new JD$Type$ref$AbiTagState$P();
    private JD$Type$ref$AbiTagState$P() {}
  }  
}
