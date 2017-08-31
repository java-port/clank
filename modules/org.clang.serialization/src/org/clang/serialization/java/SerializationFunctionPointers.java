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
package org.clang.serialization.java;

import org.clang.ast.Decl;
import org.clang.ast.FunctionDecl;
import org.clang.ast.NamedDecl;
import org.clang.ast.QualType;
import org.clang.basic.FileEntry;
import org.clang.serialization.ASTWriter.WriteASTCore$$.ModuleInfo;
import org.clang.serialization.ModuleFile;
import org.clang.serialization.TypeIdx;
import org.clang.serialization.aliases.ContinuousRangeMapUIntInt;
import org.clang.serialization.reader.impl.HeaderFileInfoTrait.internal_key_type;
import org.clank.java.std;
import org.clank.support.NativeCallback;
import org.llvm.adt.StringRef;
import org.llvm.adt.aliases.ArrayRefUInt;
import org.llvm.bitcode.BitstreamCursor;
import org.llvm.support.MemoryBuffer;

public final class SerializationFunctionPointers {

  private SerializationFunctionPointers() { }
  
  @FunctionalInterface
  public interface ModuleFile$Ref2Bool extends NativeCallback.BoolPredicate<ModuleFile/*&*/> {
    boolean $call(ModuleFile/*&*/ moduleFile);
  }

  @FunctionalInterface
  public static interface BitstreamCursorStringRef2unique_ptr {
    std.unique_ptr<MemoryBuffer> $call(BitstreamCursor /*&*/  P1, StringRef P2);
  }

  @FunctionalInterface
  public static interface DeclPredefinedDeclIDs2Void {
    void $call(Decl /*P*/  P1, /*PredefinedDeclIDs*/int P2);
  }

  @FunctionalInterface
  public static interface UIntUIntRemapBuilder2Void {
    void $call(/*uint32_t*/int P1, /*uint32_t*/int P2, ContinuousRangeMapUIntInt.Builder/*&*/  P3);
  }

  @FunctionalInterface
  public static interface ModuleFileLexicalContents2Void {
    void $call(ModuleFile /*P*/  P1, ArrayRefUInt/*<llvm.support.unaligned_uint32_t>*/ P2);
  }

  @FunctionalInterface
  public static interface internal_key_type2FileEntry {
    /*const*/ FileEntry /*P*/ $call(/*const*/ internal_key_type /*&*/  P1);
  }

  @FunctionalInterface
  public static interface ModuleInfoModuleInfo2Bool {
    boolean $call(/*const*/ ModuleInfo /*&*/  P1, /*const*/ ModuleInfo /*&*/  P2);
  }
  
  @FunctionalInterface
  public static interface UIntBool2Void {
    void $call(/*uint32_t*/int P1, boolean P2);
  }

  @FunctionalInterface
  public static interface ModuleFile2Size_type extends NativeCallback.BoolPredicate<ModuleFile> {
    boolean $call(ModuleFile /*P*/  P1);
  }
  
  @FunctionalInterface
  public static interface NamedDeclUInt2Void {
    void $call(NamedDecl P1, int P2);
  }

  @FunctionalInterface
  public static interface QualType2TypeIdx {
    TypeIdx $call(QualType P1);
  }
  
  @FunctionalInterface
  public static interface FunctionDecl2Void {
    void $call(FunctionDecl P1);
  }
}
