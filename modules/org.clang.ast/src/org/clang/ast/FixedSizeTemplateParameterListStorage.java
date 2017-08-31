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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


/// \brief Stores a list of template parameters for a TemplateDecl and its
/// derived classes. Suitable for creating on the stack.
/*template <size_t N> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::FixedSizeTemplateParameterListStorage">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 145,
 FQN="clang::FixedSizeTemplateParameterListStorage", NM="_ZN5clang37FixedSizeTemplateParameterListStorageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang37FixedSizeTemplateParameterListStorageE")
//</editor-fold>
public class FixedSizeTemplateParameterListStorage/*<size_t N>*/  {
  // This is kinda ugly: TemplateParameterList usually gets allocated
  // in a block of memory with NamedDecls appended to it. Here, to get
  // it stack allocated, we include the params as a separate
  // variable. After allocation, the TemplateParameterList object
  // treats them as part of itself.
  private final TemplateParameterList List;
  private final type$ptr<NamedDecl /*P*/> Params;// JAVA [N] = new NamedDecl /*P*/ [N];
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::FixedSizeTemplateParameterListStorage::FixedSizeTemplateParameterListStorage<N>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 155,
   FQN="clang::FixedSizeTemplateParameterListStorage::FixedSizeTemplateParameterListStorage<N>", NM="_ZN5clang37FixedSizeTemplateParameterListStorageC1ENS_14SourceLocationES1_N4llvm8ArrayRefIPNS_9NamedDeclEEES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang37FixedSizeTemplateParameterListStorageC1ENS_14SourceLocationES1_N4llvm8ArrayRefIPNS_9NamedDeclEEES1_")
  //</editor-fold>
  public FixedSizeTemplateParameterListStorage(int $N, SourceLocation TemplateLoc, 
      SourceLocation LAngleLoc, 
      ArrayRef<NamedDecl /*P*/ > Params, 
      SourceLocation RAngleLoc) {
    //JAVA: MEMORY need to prepare trailings for TemplateParameterList
    Object ListAndParams[] = new Object[TrailingObjects.totalSizeToAlloc$Same(NamedDecl.class, $N)];
    type$ptr<?> Mem = create_type$ptr(ListAndParams);
    this.Params = $toConst((type$ptr<NamedDecl /*P*/>)Mem.$add(1));
    // : List(TemplateLoc, LAngleLoc, Params, RAngleLoc) 
    //START JInit   
    this.List = new TemplateParameterList(this.Params, new SourceLocation(TemplateLoc), new SourceLocation(LAngleLoc), new ArrayRef<NamedDecl /*P*/ >(Params), new SourceLocation(RAngleLoc));
    //END JInit
    // Because we're doing an evil layout hack above, have some
    // asserts, just to double-check everything is laid out like
    // expected.
    assert (/*sizeof(Native.$star(this))*/1+$N == TrailingObjects.totalSizeToAlloc$Same(NamedDecl.class, $N)) : "Object layout not as expected";
    assert Native.$bool(Native.$eq_ptr(this.Params, List.<NamedDecl /*P*/ >getTrailingObjects(NamedDecl.class))) : "Object layout not as expected";
  }

  //<editor-fold defaultstate="collapsed" desc="clang::FixedSizeTemplateParameterListStorage::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 169,
   FQN="clang::FixedSizeTemplateParameterListStorage::get", NM="_ZN5clang37FixedSizeTemplateParameterListStorage3getEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang37FixedSizeTemplateParameterListStorage3getEv")
  //</editor-fold>
  public TemplateParameterList /*P*/ get() {
    return List;
  }

  
  @Override public String toString() {
    return "" + "List=" + List // NOI18N
              + ", Params=" + Params; // NOI18N
  }
}
