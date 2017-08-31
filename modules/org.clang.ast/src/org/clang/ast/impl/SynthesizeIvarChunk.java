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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import static org.clang.ast.impl.DeclObjCStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SynthesizeIvarChunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1499,
 FQN="(anonymous namespace)::SynthesizeIvarChunk", NM="_ZN12_GLOBAL__N_119SynthesizeIvarChunkE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN12_GLOBAL__N_119SynthesizeIvarChunkE")
//</editor-fold>
public class/*struct*/ SynthesizeIvarChunk implements ComparableLower, NativeCloneable<SynthesizeIvarChunk> {
  public long/*uint64_t*/ Size;
  public ObjCIvarDecl /*P*/ Ivar;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SynthesizeIvarChunk::SynthesizeIvarChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1502,
   FQN="(anonymous namespace)::SynthesizeIvarChunk::SynthesizeIvarChunk", NM="_ZN12_GLOBAL__N_119SynthesizeIvarChunkC1EyPN5clang12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN12_GLOBAL__N_119SynthesizeIvarChunkC1EyPN5clang12ObjCIvarDeclE")
  //</editor-fold>
  public SynthesizeIvarChunk(long/*uint64_t*/ size, ObjCIvarDecl /*P*/ ivar) {
    // : Size(size), Ivar(ivar) 
    //START JInit
    this.Size = size;
    this.Ivar = ivar;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SynthesizeIvarChunk::SynthesizeIvarChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1499,
   FQN="(anonymous namespace)::SynthesizeIvarChunk::SynthesizeIvarChunk", NM="_ZN12_GLOBAL__N_119SynthesizeIvarChunkC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN12_GLOBAL__N_119SynthesizeIvarChunkC1EOS0_")
  //</editor-fold>
  public /*inline*/ SynthesizeIvarChunk(JD$Move _dparam, final SynthesizeIvarChunk /*&&*/$Prm0) {
    // : Size(static_cast<SynthesizeIvarChunk &&>().Size), Ivar(static_cast<SynthesizeIvarChunk &&>().Ivar) 
    //START JInit
    this.Size = $Prm0.Size;
    this.Ivar = $Prm0.Ivar;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SynthesizeIvarChunk::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 1499,
   FQN="(anonymous namespace)::SynthesizeIvarChunk::operator=", NM="_ZN12_GLOBAL__N_119SynthesizeIvarChunkaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN12_GLOBAL__N_119SynthesizeIvarChunkaSEOS0_")
  //</editor-fold>
  public /*inline*/ SynthesizeIvarChunk /*&*/ $assignMove(final SynthesizeIvarChunk /*&&*/$Prm0) {
    this.Size = $Prm0.Size;
    this.Ivar = $Prm0.Ivar;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public SynthesizeIvarChunk() {
  }

  SynthesizeIvarChunk(SynthesizeIvarChunk $Prm0) {
    this.Ivar = $Prm0.Ivar;
    this.Size = $Prm0.Size;
  }
  
  public @Override boolean $less(Object other) {
    return $less_SynthesizeIvarChunk$C(this, (SynthesizeIvarChunk) other);
  }

  @Override public SynthesizeIvarChunk clone() {
    return new SynthesizeIvarChunk(this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Size=" + Size // NOI18N
              + ", Ivar=" + Ivar; // NOI18N
  }
}
