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
import org.llvm.adt.aliases.*;


/// \brief A mapping from each virtual member function to its set of
/// final overriders.
///
/// Within a class hierarchy for a given derived class, each virtual
/// member function in that hierarchy has one or more "final
/// overriders" (C++ [class.virtual]p2). A final overrider for a
/// virtual function "f" is the virtual function that will actually be
/// invoked when dispatching a call to "f" through the
/// vtable. Well-formed classes have a single final overrider for each
/// virtual function; in abstract classes, the final overrider for at
/// least one virtual function is a pure virtual function. Due to
/// multiple, virtual inheritance, it is possible for a class to have
/// more than one final overrider. Athough this is an error (per C++
/// [class.virtual]p2), it is not considered an error here: the final
/// overrider map can represent multiple final overriders for a
/// method, and it is up to the client to determine whether they are
/// problem. For example, the following class \c D has two final
/// overriders for the virtual function \c A::f(), one in \c C and one
/// in \c D:
///
/// \code
///   struct A { virtual void f(); };
///   struct B : virtual A { virtual void f(); };
///   struct C : virtual A { virtual void f(); };
///   struct D : B, C { };
/// \endcode
///
/// This data structure contains a mapping from every virtual
/// function *that does not override an existing virtual function* and
/// in every subobject where that virtual function occurs to the set
/// of virtual functions that override it. Thus, the same virtual
/// function \c A::f can actually occur in multiple subobjects of type
/// \c A due to multiple inheritance, and may be overridden by
/// different virtual functions in each, as in the following example:
///
/// \code
///   struct A { virtual void f(); };
///   struct B : A { virtual void f(); };
///   struct C : A { virtual void f(); };
///   struct D : B, C { };
/// \endcode
///
/// Unlike in the previous example, where the virtual functions \c
/// B::f and \c C::f both overrode \c A::f in the same subobject of
/// type \c A, in this example the two virtual functions both override
/// \c A::f but in *different* subobjects of type A. This is
/// represented by numbering the subobjects in which the overridden
/// and the overriding virtual member functions are located. Subobject
/// 0 represents the virtual base class subobject of that type, while
/// subobject numbers greater than 0 refer to non-virtual base class
/// subobjects of that type.
//<editor-fold defaultstate="collapsed" desc="clang::CXXFinalOverriderMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 356,
 FQN="clang::CXXFinalOverriderMap", NM="_ZN5clang20CXXFinalOverriderMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang20CXXFinalOverriderMapE")
//</editor-fold>
public class CXXFinalOverriderMap extends /*public*/ MapVectorPtrType</*const*/ CXXMethodDecl /*P*/ , OverridingMethods> implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="clang::CXXFinalOverriderMap::CXXFinalOverriderMap">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*default value*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 356,
   FQN="clang::CXXFinalOverriderMap::CXXFinalOverriderMap", NM="_ZN5clang20CXXFinalOverriderMapC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang20CXXFinalOverriderMapC1Ev")
  //</editor-fold>
  public /*inline*/ CXXFinalOverriderMap() {
    // : MapVector<const CXXMethodDecl * , OverridingMethods>() 
    //START JInit
    super(DenseMapInfo$LikePtr.$Info(), new OverridingMethods());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CXXFinalOverriderMap::~CXXFinalOverriderMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CXXInheritance.h", line = 356,
   FQN="clang::CXXFinalOverriderMap::~CXXFinalOverriderMap", NM="_ZN5clang20CXXFinalOverriderMapD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CXXInheritance.cpp -nm=_ZN5clang20CXXFinalOverriderMapD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
