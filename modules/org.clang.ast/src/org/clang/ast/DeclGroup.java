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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.java.TrailingObjectsUtils;

//<editor-fold defaultstate="collapsed" desc="clang::DeclGroup">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 28,
 FQN="clang::DeclGroup", NM="_ZN5clang9DeclGroupE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang9DeclGroupE")
//</editor-fold>
public final class DeclGroup extends TrailingObjectsJavaBase<DeclGroup, Decl /*P*/> implements /*private*/ TrailingObjects<DeclGroup, Decl /*P*/ > {
  // FIXME: Include a TypeSpecifier object.
  private /*uint*/final int NumDecls;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroup::DeclGroup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 33,
   FQN="clang::DeclGroup::DeclGroup", NM="_ZN5clang9DeclGroupC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang9DeclGroupC1Ev")
  //</editor-fold>
  private DeclGroup() {
    // : TrailingObjects<DeclGroup, Decl * >(), NumDecls(0) 
    //START JInit
    $TrailingObjects();
    this.NumDecls = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroup::DeclGroup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp", line = 28,
   FQN="clang::DeclGroup::DeclGroup", NM="_ZN5clang9DeclGroupC1EjPPNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang9DeclGroupC1EjPPNS_4DeclE")
  //</editor-fold>
  private DeclGroup(/*uint*/int numdecls, type$ptr<Decl /*P*/ /*P*/> decls) {
    // : TrailingObjects<DeclGroup, Decl * >(), NumDecls(numdecls) 
    //START JInit
    $TrailingObjects();
    this.NumDecls = numdecls;
    //END JInit
    assert super.$This$TrailingObjects != null;
    assert ($greater_uint(numdecls, 0));
    assert Native.$bool(decls);
    std.uninitialized_copy(decls, decls.$add(numdecls), 
        getTrailingObjects(Decl /*P*/.class));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroup::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp", line = 20,
   FQN="clang::DeclGroup::Create", NM="_ZN5clang9DeclGroup6CreateERNS_10ASTContextEPPNS_4DeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang9DeclGroup6CreateERNS_10ASTContextEPPNS_4DeclEj")
  //</editor-fold>
  public static DeclGroup /*P*/ Create(final ASTContext /*&*/ C, type$ptr<Decl /*P*/ /*P*/> Decls, /*uint*/int NumDecls) {
    assert ($greater_uint(NumDecls, 1)) : "Invalid DeclGroup";
    /*uint*/int Size = TrailingObjects.totalSizeToAlloc$Same(Decl.class, NumDecls);
    // JAVA: MEMORY
    Object/*void P*/ Mem;
    if (false) {
      Mem = C.Allocate(Size, AlignOf.<DeclGroup>Unnamed_enum.Alignment$Native);
    } else {
      Mem = C.Allocate$JavaRef(Size, AlignOf.<DeclGroup>Unnamed_enum.Alignment$Java);
    }
    /*NEW_EXPR [System]*/Mem = TrailingObjectsUtils.$new_uint_voidPtr(Mem, (type$ptr<?> New$Mem)->{
        return new DeclGroup(NumDecls, Decls);
     });
    return ((/*static_cast*/DeclGroup /*P*/ )(Mem));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroup::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 39,
   FQN="clang::DeclGroup::size", NM="_ZNK5clang9DeclGroup4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang9DeclGroup4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumDecls;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroup::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 41,
   FQN="clang::DeclGroup::operator[]", NM="_ZN5clang9DeclGroupixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZN5clang9DeclGroupixEj")
  //</editor-fold>
  public type$ref<Decl /*P*/ /*&*/> $at(/*uint*/int i) {
    assert ($less_uint(i, NumDecls)) : "Out-of-bounds access.";
    return getTrailingObjects(Decl /*P*/.class).$add(i).star$ref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::DeclGroup::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclGroup.h", line = 46,
   FQN="clang::DeclGroup::operator[]", NM="_ZNK5clang9DeclGroupixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclGroup.cpp -nm=_ZNK5clang9DeclGroupixEj")
  //</editor-fold>
  public Decl /*P*/ /*const*/ /*&*/ $at$Const(/*uint*/int i) /*const*/ {
    assert ($less_uint(i, NumDecls)) : "Out-of-bounds access.";
    return getTrailingObjects$Const(Decl /*P*/.class).$at(i);
  }

  
  /*friend  TrailingObjects<DeclGroup, Decl *>*/
  
  @Override public int getTrailingObjects$Offset(Class<?> clazz) { assert clazz == Decl.class : "unexpected class " + clazz; return 0; }
 
  @Override public String toString() {
    return "DeclGroup{" + "NumDecls=" + NumDecls + "\n"// NOI18N
            + super.toString() + "}"; // NOI18N
  }
}
