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

import org.clang.ast.*;
import org.llvm.support.llvm;

public class AstJavaFixedRTTI {
  /*package*/AstJavaFixedRTTI() {}

  public static boolean isa_BlockDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(FunctionDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(NamespaceDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(TagDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(TagDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static BlockDecl cast_BlockDecl(BlockDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return (BlockDecl) From;
  }

  public static BlockDecl cast_or_null_BlockDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(ExternCContextDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_BlockDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return BlockDecl.classof(From);
  }

  public static BlockDecl cast_BlockDecl(CapturedDecl/*P*/ From) {
    assert isa_BlockDecl(From);
    return llvm.cast(BlockDecl.class, From);
  }

  public static BlockDecl cast_or_null_BlockDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_BlockDecl(From);
  }

  public static BlockDecl dyn_cast_BlockDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static BlockDecl dyn_cast_or_null_BlockDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_BlockDecl(From) ? cast_BlockDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(FunctionDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return (CXXConstructorDecl) From;
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(NamespaceDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(TagDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(TagDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(CapturedDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(BlockDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConstructorDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return CXXConstructorDecl.classof(From);
  }

  public static CXXConstructorDecl cast_CXXConstructorDecl(ExternCContextDecl/*P*/ From) {
    assert isa_CXXConstructorDecl(From);
    return llvm.cast(CXXConstructorDecl.class, From);
  }

  public static CXXConstructorDecl cast_or_null_CXXConstructorDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConstructorDecl(From);
  }

  public static CXXConstructorDecl dyn_cast_CXXConstructorDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static CXXConstructorDecl dyn_cast_or_null_CXXConstructorDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_CXXConstructorDecl(From) ? cast_CXXConstructorDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(CapturedDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(BlockDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(TagDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(TagDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(ExternCContextDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(NamespaceDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return llvm.cast(CXXConversionDecl.class, From);
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXConversionDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return CXXConversionDecl.classof(From);
  }

  public static CXXConversionDecl cast_CXXConversionDecl(FunctionDecl/*P*/ From) {
    assert isa_CXXConversionDecl(From);
    return (CXXConversionDecl) From;
  }

  public static CXXConversionDecl cast_or_null_CXXConversionDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXConversionDecl(From);
  }

  public static CXXConversionDecl dyn_cast_CXXConversionDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static CXXConversionDecl dyn_cast_or_null_CXXConversionDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_CXXConversionDecl(From) ? cast_CXXConversionDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(BlockDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(TagDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(TagDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(ExternCContextDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(FunctionDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return (CXXDestructorDecl) From;
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(CapturedDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(NamespaceDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXDestructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return CXXDestructorDecl.classof(From);
  }

  public static CXXDestructorDecl cast_CXXDestructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_CXXDestructorDecl(From);
    return llvm.cast(CXXDestructorDecl.class, From);
  }

  public static CXXDestructorDecl cast_or_null_CXXDestructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXDestructorDecl(From);
  }

  public static CXXDestructorDecl dyn_cast_CXXDestructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static CXXDestructorDecl dyn_cast_or_null_CXXDestructorDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_CXXDestructorDecl(From) ? cast_CXXDestructorDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(ExternCContextDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(TagDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(TagDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(BlockDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(NamespaceDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(CapturedDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return llvm.cast(CXXMethodDecl.class, From);
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXMethodDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return CXXMethodDecl.classof(From);
  }

  public static CXXMethodDecl cast_CXXMethodDecl(FunctionDecl/*P*/ From) {
    assert isa_CXXMethodDecl(From);
    return (CXXMethodDecl) From;
  }

  public static CXXMethodDecl cast_or_null_CXXMethodDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXMethodDecl(From);
  }

  public static CXXMethodDecl dyn_cast_CXXMethodDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static CXXMethodDecl dyn_cast_or_null_CXXMethodDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_CXXMethodDecl(From) ? cast_CXXMethodDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(NamespaceDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(CapturedDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(FunctionDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(ExternCContextDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(TagDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(TagDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return (CXXRecordDecl) From;
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CXXRecordDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return CXXRecordDecl.classof(From);
  }

  public static CXXRecordDecl cast_CXXRecordDecl(BlockDecl/*P*/ From) {
    assert isa_CXXRecordDecl(From);
    return llvm.cast(CXXRecordDecl.class, From);
  }

  public static CXXRecordDecl cast_or_null_CXXRecordDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_CXXRecordDecl(From);
  }

  public static CXXRecordDecl dyn_cast_CXXRecordDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static CXXRecordDecl dyn_cast_or_null_CXXRecordDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_CXXRecordDecl(From) ? cast_CXXRecordDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(FunctionDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static CapturedDecl cast_CapturedDecl(CapturedDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return (CapturedDecl) From;
  }

  public static CapturedDecl cast_or_null_CapturedDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(NamespaceDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(ExternCContextDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(BlockDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(TagDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(TagDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_CapturedDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return CapturedDecl.classof(From);
  }

  public static CapturedDecl cast_CapturedDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_CapturedDecl(From);
    return llvm.cast(CapturedDecl.class, From);
  }

  public static CapturedDecl cast_or_null_CapturedDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_CapturedDecl(From);
  }

  public static CapturedDecl dyn_cast_CapturedDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static CapturedDecl dyn_cast_or_null_CapturedDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_CapturedDecl(From) ? cast_CapturedDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(TagDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return (ClassTemplatePartialSpecializationDecl) From;
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(NamespaceDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(CapturedDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(FunctionDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplatePartialSpecializationDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ClassTemplatePartialSpecializationDecl.classof(From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_ClassTemplatePartialSpecializationDecl(BlockDecl/*P*/ From) {
    assert isa_ClassTemplatePartialSpecializationDecl(From);
    return llvm.cast(ClassTemplatePartialSpecializationDecl.class, From);
  }

  public static ClassTemplatePartialSpecializationDecl cast_or_null_ClassTemplatePartialSpecializationDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplatePartialSpecializationDecl(From);
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_ClassTemplatePartialSpecializationDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static ClassTemplatePartialSpecializationDecl dyn_cast_or_null_ClassTemplatePartialSpecializationDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplatePartialSpecializationDecl(From) ? cast_ClassTemplatePartialSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(NamespaceDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(CapturedDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(FunctionDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(TagDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return (ClassTemplateSpecializationDecl) From;
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(BlockDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_ClassTemplateSpecializationDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ClassTemplateSpecializationDecl.classof(From);
  }

  public static ClassTemplateSpecializationDecl cast_ClassTemplateSpecializationDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ClassTemplateSpecializationDecl(From);
    return llvm.cast(ClassTemplateSpecializationDecl.class, From);
  }

  public static ClassTemplateSpecializationDecl cast_or_null_ClassTemplateSpecializationDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ClassTemplateSpecializationDecl(From);
  }

  public static ClassTemplateSpecializationDecl dyn_cast_ClassTemplateSpecializationDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static ClassTemplateSpecializationDecl dyn_cast_or_null_ClassTemplateSpecializationDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ClassTemplateSpecializationDecl(From) ? cast_ClassTemplateSpecializationDecl(From) : null;
  }

  public static boolean isa_Decl(CapturedDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(CapturedDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(FunctionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(FunctionDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(NamespaceDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(TagDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(TagDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(TagDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(ExternCContextDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(ObjCContainerDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(TranslationUnitDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(ObjCMethodDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(LinkageSpecDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_Decl(BlockDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static Decl cast_Decl(BlockDecl/*P*/ From) {
    assert isa_Decl(From);
    return (Decl) From;
  }

  public static Decl cast_or_null_Decl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_Decl(From);
  }

  public static Decl dyn_cast_Decl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static Decl dyn_cast_or_null_Decl(BlockDecl/*P*/ From) {
    return (From != null) && isa_Decl(From) ? cast_Decl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(CapturedDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(TagDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(TagDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(BlockDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(ExternCContextDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(NamespaceDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return DeclaratorDecl.classof(From);
  }

  public static DeclaratorDecl cast_DeclaratorDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return llvm.cast(DeclaratorDecl.class, From);
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_DeclaratorDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclaratorDecl cast_DeclaratorDecl(FunctionDecl/*P*/ From) {
    assert isa_DeclaratorDecl(From);
    return (DeclaratorDecl) From;
  }

  public static DeclaratorDecl cast_or_null_DeclaratorDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclaratorDecl(From);
  }

  public static DeclaratorDecl dyn_cast_DeclaratorDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static DeclaratorDecl dyn_cast_or_null_DeclaratorDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_DeclaratorDecl(From) ? cast_DeclaratorDecl(From) : null;
  }

  public static boolean isa_EnumDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(ExternCContextDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(BlockDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(NamespaceDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(FunctionDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(TagDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(TagDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return (EnumDecl) From;
  }

  public static EnumDecl cast_or_null_EnumDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_EnumDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return EnumDecl.classof(From);
  }

  public static EnumDecl cast_EnumDecl(CapturedDecl/*P*/ From) {
    assert isa_EnumDecl(From);
    return llvm.cast(EnumDecl.class, From);
  }

  public static EnumDecl cast_or_null_EnumDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_EnumDecl(From);
  }

  public static EnumDecl dyn_cast_EnumDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static EnumDecl dyn_cast_or_null_EnumDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_EnumDecl(From) ? cast_EnumDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(TagDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static ExternCContextDecl cast_ExternCContextDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return (ExternCContextDecl) From;
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(BlockDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(FunctionDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(NamespaceDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_ExternCContextDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ExternCContextDecl.classof(From);
  }

  public static ExternCContextDecl cast_ExternCContextDecl(CapturedDecl/*P*/ From) {
    assert isa_ExternCContextDecl(From);
    return llvm.cast(ExternCContextDecl.class, From);
  }

  public static ExternCContextDecl cast_or_null_ExternCContextDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ExternCContextDecl(From);
  }

  public static ExternCContextDecl dyn_cast_ExternCContextDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static ExternCContextDecl dyn_cast_or_null_ExternCContextDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ExternCContextDecl(From) ? cast_ExternCContextDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(BlockDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(NamespaceDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static FunctionDecl cast_FunctionDecl(FunctionDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return (FunctionDecl) From;
  }

  public static FunctionDecl cast_or_null_FunctionDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(TagDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(TagDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(CapturedDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_FunctionDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return FunctionDecl.classof(From);
  }

  public static FunctionDecl cast_FunctionDecl(ExternCContextDecl/*P*/ From) {
    assert isa_FunctionDecl(From);
    return llvm.cast(FunctionDecl.class, From);
  }

  public static FunctionDecl cast_or_null_FunctionDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_FunctionDecl(From);
  }

  public static FunctionDecl dyn_cast_FunctionDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static FunctionDecl dyn_cast_or_null_FunctionDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_FunctionDecl(From) ? cast_FunctionDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(BlockDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(NamespaceDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(TagDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(TagDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(CapturedDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(ExternCContextDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return LinkageSpecDecl.classof(From);
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(FunctionDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return llvm.cast(LinkageSpecDecl.class, From);
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_LinkageSpecDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static LinkageSpecDecl cast_LinkageSpecDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_LinkageSpecDecl(From);
    return (LinkageSpecDecl) From;
  }

  public static LinkageSpecDecl cast_or_null_LinkageSpecDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_LinkageSpecDecl(From);
  }

  public static LinkageSpecDecl dyn_cast_LinkageSpecDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static LinkageSpecDecl dyn_cast_or_null_LinkageSpecDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_LinkageSpecDecl(From) ? cast_LinkageSpecDecl(From) : null;
  }

  public static boolean isa_NamedDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return NamedDecl.classof(From);
  }

  public static NamedDecl cast_NamedDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return llvm.cast(NamedDecl.class, From);
  }

  public static NamedDecl cast_or_null_NamedDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static NamedDecl cast_NamedDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return (NamedDecl) From;
  }

  public static NamedDecl cast_or_null_NamedDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return NamedDecl.classof(From);
  }

  public static NamedDecl cast_NamedDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return llvm.cast(NamedDecl.class, From);
  }

  public static NamedDecl cast_or_null_NamedDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(TagDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static NamedDecl cast_NamedDecl(TagDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return (NamedDecl) From;
  }

  public static NamedDecl cast_or_null_NamedDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return NamedDecl.classof(From);
  }

  public static NamedDecl cast_NamedDecl(ExternCContextDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return llvm.cast(NamedDecl.class, From);
  }

  public static NamedDecl cast_or_null_NamedDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return NamedDecl.classof(From);
  }

  public static NamedDecl cast_NamedDecl(BlockDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return llvm.cast(NamedDecl.class, From);
  }

  public static NamedDecl cast_or_null_NamedDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return NamedDecl.classof(From);
  }

  public static NamedDecl cast_NamedDecl(CapturedDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return llvm.cast(NamedDecl.class, From);
  }

  public static NamedDecl cast_or_null_NamedDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static NamedDecl cast_NamedDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return (NamedDecl) From;
  }

  public static NamedDecl cast_or_null_NamedDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static NamedDecl cast_NamedDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return (NamedDecl) From;
  }

  public static NamedDecl cast_or_null_NamedDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static NamedDecl cast_NamedDecl(NamespaceDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return (NamedDecl) From;
  }

  public static NamedDecl cast_or_null_NamedDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamedDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static NamedDecl cast_NamedDecl(FunctionDecl/*P*/ From) {
    assert isa_NamedDecl(From);
    return (NamedDecl) From;
  }

  public static NamedDecl cast_or_null_NamedDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_NamedDecl(From);
  }

  public static NamedDecl dyn_cast_NamedDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static NamedDecl dyn_cast_or_null_NamedDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_NamedDecl(From) ? cast_NamedDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static NamespaceDecl cast_NamespaceDecl(NamespaceDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return (NamespaceDecl) From;
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(FunctionDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(TagDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(TagDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(CapturedDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(ExternCContextDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_NamespaceDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return NamespaceDecl.classof(From);
  }

  public static NamespaceDecl cast_NamespaceDecl(BlockDecl/*P*/ From) {
    assert isa_NamespaceDecl(From);
    return llvm.cast(NamespaceDecl.class, From);
  }

  public static NamespaceDecl cast_or_null_NamespaceDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_NamespaceDecl(From);
  }

  public static NamespaceDecl dyn_cast_NamespaceDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static NamespaceDecl dyn_cast_or_null_NamespaceDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_NamespaceDecl(From) ? cast_NamespaceDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(FunctionDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(BlockDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(TagDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(TagDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(ExternCContextDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(NamespaceDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return (OMPDeclareReductionDecl) From;
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_OMPDeclareReductionDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return OMPDeclareReductionDecl.classof(From);
  }

  public static OMPDeclareReductionDecl cast_OMPDeclareReductionDecl(CapturedDecl/*P*/ From) {
    assert isa_OMPDeclareReductionDecl(From);
    return llvm.cast(OMPDeclareReductionDecl.class, From);
  }

  public static OMPDeclareReductionDecl cast_or_null_OMPDeclareReductionDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_OMPDeclareReductionDecl(From);
  }

  public static OMPDeclareReductionDecl dyn_cast_OMPDeclareReductionDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static OMPDeclareReductionDecl dyn_cast_or_null_OMPDeclareReductionDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_OMPDeclareReductionDecl(From) ? cast_OMPDeclareReductionDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return (ObjCCategoryDecl) From;
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(TagDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(NamespaceDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(CapturedDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(BlockDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryDecl.classof(From);
  }

  public static ObjCCategoryDecl cast_ObjCCategoryDecl(FunctionDecl/*P*/ From) {
    assert isa_ObjCCategoryDecl(From);
    return llvm.cast(ObjCCategoryDecl.class, From);
  }

  public static ObjCCategoryDecl cast_or_null_ObjCCategoryDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryDecl(From);
  }

  public static ObjCCategoryDecl dyn_cast_ObjCCategoryDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static ObjCCategoryDecl dyn_cast_or_null_ObjCCategoryDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryDecl(From) ? cast_ObjCCategoryDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return (ObjCCategoryImplDecl) From;
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(TagDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(NamespaceDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(CapturedDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(FunctionDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(BlockDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCCategoryImplDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ObjCCategoryImplDecl.classof(From);
  }

  public static ObjCCategoryImplDecl cast_ObjCCategoryImplDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ObjCCategoryImplDecl(From);
    return llvm.cast(ObjCCategoryImplDecl.class, From);
  }

  public static ObjCCategoryImplDecl cast_or_null_ObjCCategoryImplDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCCategoryImplDecl(From);
  }

  public static ObjCCategoryImplDecl dyn_cast_ObjCCategoryImplDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static ObjCCategoryImplDecl dyn_cast_or_null_ObjCCategoryImplDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ObjCCategoryImplDecl(From) ? cast_ObjCCategoryImplDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(FunctionDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(NamespaceDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(BlockDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return (ObjCContainerDecl) From;
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(CapturedDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(TagDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCContainerDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ObjCContainerDecl.classof(From);
  }

  public static ObjCContainerDecl cast_ObjCContainerDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ObjCContainerDecl(From);
    return llvm.cast(ObjCContainerDecl.class, From);
  }

  public static ObjCContainerDecl cast_or_null_ObjCContainerDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCContainerDecl(From);
  }

  public static ObjCContainerDecl dyn_cast_ObjCContainerDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static ObjCContainerDecl dyn_cast_or_null_ObjCContainerDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ObjCContainerDecl(From) ? cast_ObjCContainerDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return (ObjCImplDecl) From;
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(NamespaceDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(BlockDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(CapturedDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(FunctionDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ObjCImplDecl.classof(From);
  }

  public static ObjCImplDecl cast_ObjCImplDecl(TagDecl/*P*/ From) {
    assert isa_ObjCImplDecl(From);
    return llvm.cast(ObjCImplDecl.class, From);
  }

  public static ObjCImplDecl cast_or_null_ObjCImplDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplDecl(From);
  }

  public static ObjCImplDecl dyn_cast_ObjCImplDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static ObjCImplDecl dyn_cast_or_null_ObjCImplDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplDecl(From) ? cast_ObjCImplDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(FunctionDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(NamespaceDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(BlockDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return (ObjCImplementationDecl) From;
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(CapturedDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(TagDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCImplementationDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ObjCImplementationDecl.classof(From);
  }

  public static ObjCImplementationDecl cast_ObjCImplementationDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ObjCImplementationDecl(From);
    return llvm.cast(ObjCImplementationDecl.class, From);
  }

  public static ObjCImplementationDecl cast_or_null_ObjCImplementationDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCImplementationDecl(From);
  }

  public static ObjCImplementationDecl dyn_cast_ObjCImplementationDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static ObjCImplementationDecl dyn_cast_or_null_ObjCImplementationDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ObjCImplementationDecl(From) ? cast_ObjCImplementationDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(FunctionDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(BlockDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(TagDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(CapturedDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return (ObjCInterfaceDecl) From;
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(NamespaceDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCInterfaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ObjCInterfaceDecl.classof(From);
  }

  public static ObjCInterfaceDecl cast_ObjCInterfaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ObjCInterfaceDecl(From);
    return llvm.cast(ObjCInterfaceDecl.class, From);
  }

  public static ObjCInterfaceDecl cast_or_null_ObjCInterfaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCInterfaceDecl(From);
  }

  public static ObjCInterfaceDecl dyn_cast_ObjCInterfaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static ObjCInterfaceDecl dyn_cast_or_null_ObjCInterfaceDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ObjCInterfaceDecl(From) ? cast_ObjCInterfaceDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(FunctionDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return (ObjCMethodDecl) From;
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(TagDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(BlockDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(NamespaceDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCMethodDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ObjCMethodDecl.classof(From);
  }

  public static ObjCMethodDecl cast_ObjCMethodDecl(CapturedDecl/*P*/ From) {
    assert isa_ObjCMethodDecl(From);
    return llvm.cast(ObjCMethodDecl.class, From);
  }

  public static ObjCMethodDecl cast_or_null_ObjCMethodDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCMethodDecl(From);
  }

  public static ObjCMethodDecl dyn_cast_ObjCMethodDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static ObjCMethodDecl dyn_cast_or_null_ObjCMethodDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ObjCMethodDecl(From) ? cast_ObjCMethodDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(TagDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(BlockDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(NamespaceDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return (ObjCProtocolDecl) From;
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(CapturedDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(FunctionDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_ObjCProtocolDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ObjCProtocolDecl.classof(From);
  }

  public static ObjCProtocolDecl cast_ObjCProtocolDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ObjCProtocolDecl(From);
    return llvm.cast(ObjCProtocolDecl.class, From);
  }

  public static ObjCProtocolDecl cast_or_null_ObjCProtocolDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ObjCProtocolDecl(From);
  }

  public static ObjCProtocolDecl dyn_cast_ObjCProtocolDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static ObjCProtocolDecl dyn_cast_or_null_ObjCProtocolDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ObjCProtocolDecl(From) ? cast_ObjCProtocolDecl(From) : null;
  }

  public static boolean isa_RecordDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(ExternCContextDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(BlockDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(NamespaceDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(FunctionDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(CapturedDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(TagDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(TagDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return (RecordDecl) From;
  }

  public static RecordDecl cast_or_null_RecordDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_RecordDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return RecordDecl.classof(From);
  }

  public static RecordDecl cast_RecordDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_RecordDecl(From);
    return llvm.cast(RecordDecl.class, From);
  }

  public static RecordDecl cast_or_null_RecordDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_RecordDecl(From);
  }

  public static RecordDecl dyn_cast_RecordDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static RecordDecl dyn_cast_or_null_RecordDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_RecordDecl(From) ? cast_RecordDecl(From) : null;
  }

  public static boolean isa_TagDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(TagDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static TagDecl cast_TagDecl(TagDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return (TagDecl) From;
  }

  public static TagDecl cast_or_null_TagDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(CapturedDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(NamespaceDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(BlockDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(FunctionDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(ExternCContextDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TagDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return TagDecl.classof(From);
  }

  public static TagDecl cast_TagDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_TagDecl(From);
    return llvm.cast(TagDecl.class, From);
  }

  public static TagDecl cast_or_null_TagDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_TagDecl(From);
  }

  public static TagDecl dyn_cast_TagDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static TagDecl dyn_cast_or_null_TagDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_TagDecl(From) ? cast_TagDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return (TranslationUnitDecl) From;
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(FunctionDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(CapturedDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(NamespaceDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(BlockDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(ExternCContextDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TranslationUnitDecl(TagDecl/*P*/ From) {
    assert From != null;
    return TranslationUnitDecl.classof(From);
  }

  public static TranslationUnitDecl cast_TranslationUnitDecl(TagDecl/*P*/ From) {
    assert isa_TranslationUnitDecl(From);
    return llvm.cast(TranslationUnitDecl.class, From);
  }

  public static TranslationUnitDecl cast_or_null_TranslationUnitDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_TranslationUnitDecl(From);
  }

  public static TranslationUnitDecl dyn_cast_TranslationUnitDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static TranslationUnitDecl dyn_cast_or_null_TranslationUnitDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_TranslationUnitDecl(From) ? cast_TranslationUnitDecl(From) : null;
  }

  public static boolean isa_TypeDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(TagDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static TypeDecl cast_TypeDecl(TagDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return (TypeDecl) From;
  }

  public static TypeDecl cast_or_null_TypeDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(CapturedDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(NamespaceDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(FunctionDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(BlockDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_TypeDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return TypeDecl.classof(From);
  }

  public static TypeDecl cast_TypeDecl(ExternCContextDecl/*P*/ From) {
    assert isa_TypeDecl(From);
    return llvm.cast(TypeDecl.class, From);
  }

  public static TypeDecl cast_or_null_TypeDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_TypeDecl(From);
  }

  public static TypeDecl dyn_cast_TypeDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static TypeDecl dyn_cast_or_null_TypeDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_TypeDecl(From) ? cast_TypeDecl(From) : null;
  }

  public static boolean isa_ValueDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static ValueDecl cast_ValueDecl(FunctionDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return (ValueDecl) From;
  }

  public static ValueDecl cast_or_null_ValueDecl(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(FunctionDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(CapturedDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(CapturedDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(BlockDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(BlockDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(ExternCContextDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(LinkageSpecDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(TagDecl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(TagDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(TagDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(TagDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(ObjCContainerDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(TranslationUnitDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(ObjCMethodDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return ValueDecl.classof(From);
  }

  public static ValueDecl cast_ValueDecl(NamespaceDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return llvm.cast(ValueDecl.class, From);
  }

  public static ValueDecl cast_or_null_ValueDecl(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_ValueDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static ValueDecl cast_ValueDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_ValueDecl(From);
    return (ValueDecl) From;
  }

  public static ValueDecl cast_or_null_ValueDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_ValueDecl(From);
  }

  public static ValueDecl dyn_cast_ValueDecl(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static ValueDecl dyn_cast_or_null_ValueDecl(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_ValueDecl(From) ? cast_ValueDecl(From) : null;
  }

  public static boolean isa_DeclContext(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(TranslationUnitDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(TranslationUnitDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(TranslationUnitDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(TranslationUnitDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(ObjCMethodDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(ObjCMethodDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(ObjCMethodDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(ObjCMethodDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(ObjCContainerDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(ObjCContainerDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(ObjCContainerDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(ObjCContainerDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(LinkageSpecDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(LinkageSpecDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(LinkageSpecDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(LinkageSpecDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(TagDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(TagDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(TagDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(TagDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(TagDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(CapturedDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(CapturedDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(CapturedDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(CapturedDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(CapturedDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(ExternCContextDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(ExternCContextDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(ExternCContextDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(ExternCContextDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(BlockDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(BlockDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(BlockDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(BlockDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(BlockDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(FunctionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(FunctionDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(FunctionDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(FunctionDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(FunctionDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(OMPDeclareReductionDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(OMPDeclareReductionDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(OMPDeclareReductionDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(OMPDeclareReductionDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static boolean isa_DeclContext(NamespaceDecl/*P*/ From) {
    assert From != null;
    return true;
  }

  public static DeclContext cast_DeclContext(NamespaceDecl/*P*/ From) {
    assert isa_DeclContext(From);
    return (DeclContext) From;
  }

  public static DeclContext cast_or_null_DeclContext(NamespaceDecl/*P*/ From) {
    return (From == null) ? null : cast_DeclContext(From);
  }

  public static DeclContext dyn_cast_DeclContext(NamespaceDecl/*P*/ From) {
    assert From != null;
    return isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }

  public static DeclContext dyn_cast_or_null_DeclContext(NamespaceDecl/*P*/ From) {
    return (From != null) && isa_DeclContext(From) ? cast_DeclContext(From) : null;
  }
}
