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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;

/// \brief Data structure that captures multiple levels of template argument
/// lists for use in template instantiation.
///
/// Multiple levels of template arguments occur when instantiating the 
/// definitions of member templates. For example:
///
/// \code
/// template<typename T>
/// struct X {
///   template<T Value>
///   struct Y {
///     void f();
///   };
/// };
/// \endcode
///
/// When instantiating X<int>::Y<17>::f, the multi-level template argument
/// list will contain a template argument list (int) at depth 0 and a
/// template argument list (17) at depth 1.
//<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 42,
 FQN="clang::MultiLevelTemplateArgumentList", NM="_ZN5clang30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang30MultiLevelTemplateArgumentListE")
//</editor-fold>
public class MultiLevelTemplateArgumentList implements Destructors.ClassWithDestructor {
  /// \brief The template argument list at a certain template depth 
  /*typedef ArrayRef<TemplateArgument> ArgList*/
//  public final class ArgList extends ArrayRef<TemplateArgument>{ };
  
  /// \brief The template argument lists, stored from the innermost template
  /// argument list (first) to the outermost template argument list (last).
  private SmallVector<ArrayRef<TemplateArgument>> TemplateArgumentLists;
/*public:*/
  /// \brief Construct an empty set of template argument lists.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::MultiLevelTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 52,
   FQN="clang::MultiLevelTemplateArgumentList::MultiLevelTemplateArgumentList", NM="_ZN5clang30MultiLevelTemplateArgumentListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang30MultiLevelTemplateArgumentListC1Ev")
  //</editor-fold>
  public MultiLevelTemplateArgumentList() {
    // : TemplateArgumentLists() 
    //START JInit
    this.TemplateArgumentLists = new SmallVector<ArrayRef<TemplateArgument>>(4, new ArrayRef<TemplateArgument>());
    //END JInit
  }

  
  /// \brief Construct a single-level template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::MultiLevelTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 55,
   FQN="clang::MultiLevelTemplateArgumentList::MultiLevelTemplateArgumentList", NM="_ZN5clang30MultiLevelTemplateArgumentListC1ERKNS_20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang30MultiLevelTemplateArgumentListC1ERKNS_20TemplateArgumentListE")
  //</editor-fold>
  public /*explicit*/ MultiLevelTemplateArgumentList(final /*const*/ TemplateArgumentList /*&*/ TemplateArgs) {
    // : TemplateArgumentLists() 
    //START JInit
    this.TemplateArgumentLists = new SmallVector<ArrayRef<TemplateArgument>>(4, new ArrayRef<TemplateArgument>());
    //END JInit
    addOuterTemplateArguments($AddrOf(TemplateArgs));
  }

  
  /// \brief Determine the number of levels in this template argument
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::getNumLevels">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 62,
   FQN="clang::MultiLevelTemplateArgumentList::getNumLevels", NM="_ZNK5clang30MultiLevelTemplateArgumentList12getNumLevelsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang30MultiLevelTemplateArgumentList12getNumLevelsEv")
  //</editor-fold>
  public /*uint*/int getNumLevels() /*const*/ {
    return TemplateArgumentLists.size();
  }

  
  /// \brief Retrieve the template argument at a given depth and index.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 65,
   FQN="clang::MultiLevelTemplateArgumentList::operator()", NM="_ZNK5clang30MultiLevelTemplateArgumentListclEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang30MultiLevelTemplateArgumentListclEjj")
  //</editor-fold>
  public /*const*/ TemplateArgument /*&*/ $call(/*uint*/int Depth, /*uint*/int Index) /*const*/ {
    assert ($less_uint(Depth, TemplateArgumentLists.size()));
    assert ($less_uint(Index, TemplateArgumentLists.$at$Const(getNumLevels() - Depth - 1).size()));
    return TemplateArgumentLists.$at$Const(getNumLevels() - Depth - 1).$at(Index);
  }

  
  /// \brief Determine whether there is a non-NULL template argument at the
  /// given depth and index.
  ///
  /// There must exist a template argument list at the given depth.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::hasTemplateArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 75,
   FQN="clang::MultiLevelTemplateArgumentList::hasTemplateArgument", NM="_ZNK5clang30MultiLevelTemplateArgumentList19hasTemplateArgumentEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang30MultiLevelTemplateArgumentList19hasTemplateArgumentEjj")
  //</editor-fold>
  public boolean hasTemplateArgument(/*uint*/int Depth, /*uint*/int Index) /*const*/ {
    assert ($less_uint(Depth, TemplateArgumentLists.size()));
    if ($greatereq_uint(Index, TemplateArgumentLists.$at$Const(getNumLevels() - Depth - 1).size())) {
      return false;
    }
    
    return !(/*Deref*/this).$call(Depth, Index).isNull();
  }

  
  /// \brief Clear out a specific template argument.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::setArgument">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 85,
   FQN="clang::MultiLevelTemplateArgumentList::setArgument", NM="_ZN5clang30MultiLevelTemplateArgumentList11setArgumentEjjNS_16TemplateArgumentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang30MultiLevelTemplateArgumentList11setArgumentEjjNS_16TemplateArgumentE")
  //</editor-fold>
  public void setArgument(/*uint*/int Depth, /*uint*/int Index, 
             TemplateArgument Arg) {
    assert ($less_uint(Depth, TemplateArgumentLists.size()));
    assert ($less_uint(Index, TemplateArgumentLists.$at(getNumLevels() - Depth - 1).size()));
    ((/*const_cast*/TemplateArgument /*&*/ )(TemplateArgumentLists.$at(getNumLevels() - Depth - 1).$at(Index))).$assign(
        Arg
    );
  }

  
  /// \brief Add a new outermost level to the multi-level template argument 
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::addOuterTemplateArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 96,
   FQN="clang::MultiLevelTemplateArgumentList::addOuterTemplateArguments", NM="_ZN5clang30MultiLevelTemplateArgumentList25addOuterTemplateArgumentsEPKNS_20TemplateArgumentListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang30MultiLevelTemplateArgumentList25addOuterTemplateArgumentsEPKNS_20TemplateArgumentListE")
  //</editor-fold>
  public void addOuterTemplateArguments(/*const*/ TemplateArgumentList /*P*/ TemplateArgs) {
    addOuterTemplateArguments(new ArrayRef<TemplateArgument>(TemplateArgs.data(), 
            TemplateArgs.size(), false));
  }

  
  /// \brief Add a new outmost level to the multi-level template argument
  /// list.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::addOuterTemplateArguments">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 103,
   FQN="clang::MultiLevelTemplateArgumentList::addOuterTemplateArguments", NM="_ZN5clang30MultiLevelTemplateArgumentList25addOuterTemplateArgumentsEN4llvm8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang30MultiLevelTemplateArgumentList25addOuterTemplateArgumentsEN4llvm8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public void addOuterTemplateArguments(ArrayRef<TemplateArgument> Args) {
    TemplateArgumentLists.push_back(Args);
  }

  
  /// \brief Retrieve the innermost template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::getInnermost">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 108,
   FQN="clang::MultiLevelTemplateArgumentList::getInnermost", NM="_ZNK5clang30MultiLevelTemplateArgumentList12getInnermostEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZNK5clang30MultiLevelTemplateArgumentList12getInnermostEv")
  //</editor-fold>
  public /*const*/ArrayRef<TemplateArgument> /*&*/ getInnermost() /*const*/ {
    return TemplateArgumentLists.front$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::MultiLevelTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 42,
   FQN="clang::MultiLevelTemplateArgumentList::MultiLevelTemplateArgumentList", NM="_ZN5clang30MultiLevelTemplateArgumentListC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang30MultiLevelTemplateArgumentListC1EOS0_")
  //</editor-fold>
  public /*inline*/ MultiLevelTemplateArgumentList(JD$Move _dparam, final MultiLevelTemplateArgumentList /*&&*/$Prm0) {
    // : TemplateArgumentLists(static_cast<MultiLevelTemplateArgumentList &&>().TemplateArgumentLists) 
    //START JInit
    this.TemplateArgumentLists = new SmallVector<ArrayRef<TemplateArgument>>(JD$Move.INSTANCE, $Prm0.TemplateArgumentLists);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MultiLevelTemplateArgumentList::~MultiLevelTemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Template.h", line = 42,
   FQN="clang::MultiLevelTemplateArgumentList::~MultiLevelTemplateArgumentList", NM="_ZN5clang30MultiLevelTemplateArgumentListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN5clang30MultiLevelTemplateArgumentListD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    TemplateArgumentLists.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "TemplateArgumentLists=" + TemplateArgumentLists; // NOI18N
  }
}
