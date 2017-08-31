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

package org.llvm.option;

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;

/// ArgList - Ordered collection of driver arguments.
///
/// The ArgList class manages a list of Arg instances as well as
/// auxiliary data and convenience methods to allow Tools to quickly
/// check for the presence of Arg instances for a particular Option
/// and to iterate over groups of arguments.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 94,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 92,
 FQN="llvm::opt::ArgList", NM="_ZN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgListE")
//</editor-fold>
public abstract class ArgList implements Destructors.ClassWithDestructor, Iterable<Arg> {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::ArgList">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 94,
   FQN = "llvm::opt::ArgList::ArgList", NM = "_ZN4llvm3opt7ArgListC1ERKS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgListC1ERKS1_")
  //</editor-fold>
  private ArgList(/*const*/ArgList /*&*/ $Prm0) {/*<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY>>>*/}

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 94,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 95,
   FQN = "llvm::opt::ArgList::operator=", NM = "_ZN4llvm3opt7ArgListaSERKS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgListaSERKS1_")
  //</editor-fold>
  private void $assign(/*const*/ArgList /*&*/ $Prm0) {/*<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY>>>*/}

/*public:*/
  /*typedef SmallVector<Arg *, 16> arglist_type*/
//  public final class arglist_type extends SmallVector<Arg /*P*/>{ };
  /*typedef arglist_type::iterator iterator*/
//  public final class iterator extends type$ptr<Arg /*P*//*,16*/> { };
  /*typedef arglist_type::const_iterator const_iterator*/
//  public final class const_iterator extends type$ptr<Arg /*P*//*,16*/> { };
  /*typedef arglist_type::reverse_iterator reverse_iterator*/
//  public final class reverse_iterator extends std.reverse_iterator<Arg /*P*/>{ };
  /*typedef arglist_type::const_reverse_iterator const_reverse_iterator*/
//  public final class const_reverse_iterator extends std.reverse_iterator<Arg /*P*/>{ };
/*private:*/
  /// The internal list of arguments.
  private SmallVector<Arg /*P*/> Args;
/*protected:*/
  // Make the default special members protected so they won't be used to slice
  // derived objects, but can still be used by derived objects to implement
  // their own special members.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::ArgList">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 110,
            old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 111,
   FQN="llvm::opt::ArgList::ArgList", NM="_ZN4llvm3opt7ArgListC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgListC1Ev")
  //</editor-fold>
  protected ArgList() {
    /* : Args()*//* = default*/
    //START JInit
    this.Args = new SmallVector<Arg /*P*/>(16, (Arg/*P*/)null);
    //END JInit
  }  

  // Explicit move operations to ensure the container is cleared post-move
  // otherwise it could lead to a double-delete in the case of moving of an
  // InputArgList which deletes the contents of the container. If we could fix
  // up the ownership here (delegate storage/ownership to the derived class so
  // it can be a container of unique_ptr) this would be simpler.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::ArgList">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 116,
   FQN="llvm::opt::ArgList::ArgList", NM="_ZN4llvm3opt7ArgListC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgListC1EOS1_")
//</editor-fold>
  protected ArgList(JD$Move _dparam, ArgList /*&&*/RHS) {
    /* : Args(std::move(RHS.Args))*/
    //START JInit
    this.Args = new SmallVector<Arg /*P*/>(JD$Move.INSTANCE, std.move(RHS.Args));
    //END JInit
    RHS.Args.clear();
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::operator=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 117,
   FQN="llvm::opt::ArgList::operator=", NM="_ZN4llvm3opt7ArgListaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgListaSEOS1_")
//</editor-fold>
  protected ArgList /*&*/ $assignMove(ArgList /*&&*/RHS) {
    Args.$assignMove(std.move(RHS.Args));
    RHS.Args.clear();
    return /*Deref*/this;
  }
  
  // Protect the dtor to ensure this type is never destroyed polymorphically.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::~ArgList">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 123,
          old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 36,
   FQN="llvm::opt::ArgList::~ArgList", NM="_ZN4llvm3opt7ArgListD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgListD0Ev")
//</editor-fold>
  public/*protected*/ void $destroy()/* = default*/ {
    //START JDestroy
    Args.$destroy();
    //END JDestroy
  }

/*public:*/
  
  /// @name Arg Access
  /// @{
  
  /// append - Append \p A to the arg list.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::append">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 37,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 39,
   FQN="llvm::opt::ArgList::append", NM="_ZN4llvm3opt7ArgList6appendEPNS0_3ArgE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgList6appendEPNS0_3ArgE")
  //</editor-fold>
  public void append(Arg /*P*/ A) {
    Args.push_back(A);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getArgs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 133,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 124,
   FQN="llvm::opt::ArgList::getArgs", NM="_ZN4llvm3opt7ArgList7getArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgList7getArgsEv")
  //</editor-fold>
  public SmallVector<Arg /*P*/>/*&*/ getArgs() {
    return Args;
  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getArgs">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 134,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 125,
//   FQN="llvm::opt::ArgList::getArgs", NM="_ZNK4llvm3opt7ArgList7getArgsEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList7getArgsEv")
//  //</editor-fold>
//  public /*const*/ SmallVector<Arg /*P*/ , 16> /*&*/ getArgs() /*const*/ {
//    return Args;
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 127,
   FQN="llvm::opt::ArgList::size", NM="_ZNK4llvm3opt7ArgList4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Args.size();
  }

  
  /// @}
  /// @name Arg Iteration
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 142,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 133,
   FQN="llvm::opt::ArgList::begin", NM="_ZN4llvm3opt7ArgList5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgList5beginEv")
  //</editor-fold>
  public type$ptr<Arg /*P*//*,16*/>  begin() {
    return Args.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 143,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 134,
   FQN="llvm::opt::ArgList::end", NM="_ZN4llvm3opt7ArgList3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgList3endEv")
  //</editor-fold>
  public type$ptr<Arg /*P*//*,16*/>  end() {
    return Args.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::rbegin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 136,
   FQN="llvm::opt::ArgList::rbegin", NM="_ZN4llvm3opt7ArgList6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgList6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<Arg /*P*/> rbegin() {
    return Args.rbegin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::rend">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 137,
   FQN="llvm::opt::ArgList::rend", NM="_ZN4llvm3opt7ArgList4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgList4rendEv")
  //</editor-fold>
  public std.reverse_iterator<Arg /*P*/> rend() {
    return Args.rend();
  }

  
  ////<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::begin">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 148,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 139,
//   FQN="llvm::opt::ArgList::begin", NM="_ZNK4llvm3opt7ArgList5beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList5beginEv")
//  //</editor-fold>
//  public type$ptr<Arg /*P*//*,16*/>  begin() /*const*/ {
//    return Args.begin();
//  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::end">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 149,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 140,
//   FQN="llvm::opt::ArgList::end", NM="_ZNK4llvm3opt7ArgList3endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList3endEv")
//  //</editor-fold>
//  public type$ptr<Arg /*P*//*,16*/>  end() /*const*/ {
//    return Args.end();
//  }

  
  ////<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::rbegin">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 151,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 142,
//   FQN="llvm::opt::ArgList::rbegin", NM="_ZNK4llvm3opt7ArgList6rbeginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList6rbeginEv")
//  //</editor-fold>
//  public std.reverse_iterator<Arg /*P*/> rbegin() /*const*/ {
//    return Args.rbegin();
//  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::rend">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 152,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 143,
//   FQN="llvm::opt::ArgList::rend", NM="_ZNK4llvm3opt7ArgList4rendEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList4rendEv")
//  //</editor-fold>
//  public std.reverse_iterator<Arg /*P*/> rend() /*const*/ {
//    return Args.rend();
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::filtered_begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 154,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 145,
   FQN="llvm::opt::ArgList::filtered_begin", NM="_ZNK4llvm3opt7ArgList14filtered_beginENS0_12OptSpecifierES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList14filtered_beginENS0_12OptSpecifierES2_S2_")
  //</editor-fold>
  public arg_iterator filtered_begin() /*const*/ {
    return filtered_begin(new OptSpecifier(0/*U*/), new OptSpecifier(0/*U*/), 
            new OptSpecifier(0/*U*/));
  }
  public arg_iterator filtered_begin(OptSpecifier Id0/*= 0UU*/) /*const*/ {
    return filtered_begin(Id0, new OptSpecifier(0/*U*/), 
            new OptSpecifier(0/*U*/));
  }
  public arg_iterator filtered_begin(OptSpecifier Id0/*= 0UU*/, OptSpecifier Id1/*= 0UU*/) /*const*/ {
    return filtered_begin(Id0, Id1, 
            new OptSpecifier(0/*U*/));
  }
  public arg_iterator filtered_begin(OptSpecifier Id0/*= 0UU*/, OptSpecifier Id1/*= 0UU*/,
          OptSpecifier Id2/*= 0UU*/) /*const*/ {
    return new arg_iterator(Args.begin(), /*Deref*/this, /*NO_COPY*/Id0, /*NO_COPY*/Id1, /*NO_COPY*/Id2);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::filtered_end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 158,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 149,
   FQN="llvm::opt::ArgList::filtered_end", NM="_ZNK4llvm3opt7ArgList12filtered_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList12filtered_endEv")
  //</editor-fold>
  public arg_iterator filtered_end() /*const*/ {
    return new arg_iterator(Args.end(), /*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::filtered">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 162,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 153,
   FQN="llvm::opt::ArgList::filtered", NM="_ZNK4llvm3opt7ArgList8filteredENS0_12OptSpecifierES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList8filteredENS0_12OptSpecifierES2_S2_")
  //</editor-fold>
  public iterator_range<Arg> filtered() /*const*/ {
    return filtered(new OptSpecifier(0/*U*/), 
          new OptSpecifier(0/*U*/), 
          new OptSpecifier(0/*U*/));
  }
  public iterator_range<Arg> filtered(OptSpecifier Id0/*= 0UU*/) /*const*/ {
    return filtered(Id0, 
          new OptSpecifier(0/*U*/), 
          new OptSpecifier(0/*U*/));
  }
  public iterator_range<Arg> filtered(OptSpecifier Id0/*= 0UU*/, 
          OptSpecifier Id1/*= 0UU*/) /*const*/ {
    return filtered(Id0, 
          Id1, 
          new OptSpecifier(0/*U*/));
  }
  public iterator_range<Arg> filtered(OptSpecifier Id0/*= 0UU*/, 
          OptSpecifier Id1/*= 0UU*/, 
          OptSpecifier Id2/*= 0UU*/) /*const*/ {
    return make_range(filtered_begin(/*NO_COPY*/Id0, /*NO_COPY*/Id1, /*NO_COPY*/Id2), filtered_end());
  }

  
  /// @}
  /// @name Arg Removal
  /// @{
  
  /// eraseArg - Remove any option matching \p Id.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::eraseArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 41,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 43,
   FQN="llvm::opt::ArgList::eraseArg", NM="_ZN4llvm3opt7ArgList8eraseArgENS0_12OptSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZN4llvm3opt7ArgList8eraseArgENS0_12OptSpecifierE")
  //</editor-fold>
  public void eraseArg(final OptSpecifier Id) {
    Args.erase(std.remove_if(begin(), end(), new BoolPredicate<Arg>() {
      
      @Override
      public boolean $call(Arg A) {
        return A.getOption().matches(Id);
      }
    }), end());
  }

  
  /// @}
  /// @name Arg Access
  /// @{
  
  /// hasArg - Does the arg list contain any option matching \p Id.
  ///
  /// \p Claim Whether the argument should be claimed, if it exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::hasArgNoClaim">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 173,
   FQN="llvm::opt::ArgList::hasArgNoClaim", NM="_ZNK4llvm3opt7ArgList13hasArgNoClaimENS0_12OptSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList13hasArgNoClaimENS0_12OptSpecifierE")
  //</editor-fold>
  public boolean hasArgNoClaim(OptSpecifier Id) /*const*/ {
    return getLastArgNoClaim(/*NO_COPY*/Id) != null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::hasArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 176,
   FQN="llvm::opt::ArgList::hasArg", NM="_ZNK4llvm3opt7ArgList6hasArgENS0_12OptSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList6hasArgENS0_12OptSpecifierE")
  //</editor-fold>
  public boolean hasArg(OptSpecifier Id) /*const*/ {
    return getLastArg(/*NO_COPY*/Id) != null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::hasArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 188,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 179,
   FQN="llvm::opt::ArgList::hasArg", NM="_ZNK4llvm3opt7ArgList6hasArgENS0_12OptSpecifierES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList6hasArgENS0_12OptSpecifierES2_")
  //</editor-fold>
  public boolean hasArg(OptSpecifier Id0, OptSpecifier Id1) /*const*/ {
    return getLastArg(/*NO_COPY*/Id0, /*NO_COPY*/Id1) != null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::hasArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 191,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 182,
   FQN="llvm::opt::ArgList::hasArg", NM="_ZNK4llvm3opt7ArgList6hasArgENS0_12OptSpecifierES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList6hasArgENS0_12OptSpecifierES2_S2_")
  //</editor-fold>
  public boolean hasArg(OptSpecifier Id0, OptSpecifier Id1, OptSpecifier Id2) /*const*/ {
    return getLastArg(/*NO_COPY*/Id0, /*NO_COPY*/Id1, /*NO_COPY*/Id2) != null;
  }

  
  /// getLastArg - Return the last argument matching \p Id, or null.
  ///
  /// \p Claim Whether the argument should be claimed, if it exists.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArgNoClaim">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 47,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 49,
   FQN="llvm::opt::ArgList::getLastArgNoClaim", NM="_ZNK4llvm3opt7ArgList17getLastArgNoClaimENS0_12OptSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList17getLastArgNoClaimENS0_12OptSpecifierE")
  //</editor-fold>
  public Arg /*P*/ getLastArgNoClaim(OptSpecifier Id) /*const*/ {
    // FIXME: Make search efficient?
    for (std.reverse_iterator<Arg /*P*/> it = rbegin(), ie = rend(); $noteq_reverse_iterator$C(it, ie); it.$preInc())  {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id)) {
        return it.$star();
      }
    }
    return null;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArgNoClaim">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 55,
 old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 57,
   FQN="llvm::opt::ArgList::getLastArgNoClaim", NM="_ZNK4llvm3opt7ArgList17getLastArgNoClaimENS0_12OptSpecifierES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList17getLastArgNoClaimENS0_12OptSpecifierES2_")
//</editor-fold>
  public Arg /*P*/ getLastArgNoClaim(OptSpecifier Id0, OptSpecifier Id1) /*const*/ {
    // FIXME: Make search efficient?
    for (std.reverse_iterator<Arg /*P*/> it = rbegin(), ie = rend(); $noteq_reverse_iterator$C(it, ie); it.$preInc())  {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id1)) {
        return it.$star();
      }
    }
    return null;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArgNoClaim">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 64,
   FQN="llvm::opt::ArgList::getLastArgNoClaim", NM="_ZNK4llvm3opt7ArgList17getLastArgNoClaimENS0_12OptSpecifierES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList17getLastArgNoClaimENS0_12OptSpecifierES2_S2_")
//</editor-fold>
  public Arg /*P*/ getLastArgNoClaim(OptSpecifier Id0, OptSpecifier Id1,
                  OptSpecifier Id2) /*const*/ {
    // FIXME: Make search efficient?
    for (std.reverse_iterator<Arg /*P*/> it = rbegin(), ie = rend(); $noteq_reverse_iterator$C(it, ie); it.$preInc())  {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0) || (it.$star()).getOption().matches(/*NO_COPY*/Id1)
              || (it.$star()).getOption().matches(/*NO_COPY*/Id2)) {
        return it.$star();
      }
    }
    return null;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArgNoClaim">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 74,
   FQN="llvm::opt::ArgList::getLastArgNoClaim", NM="_ZNK4llvm3opt7ArgList17getLastArgNoClaimENS0_12OptSpecifierES2_S2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList17getLastArgNoClaimENS0_12OptSpecifierES2_S2_S2_")
//</editor-fold>
  public Arg /*P*/ getLastArgNoClaim(OptSpecifier Id0, OptSpecifier Id1,
                  OptSpecifier Id2, OptSpecifier Id3) /*const*/ {
    // FIXME: Make search efficient?
    for (std.reverse_iterator<Arg /*P*/> it = rbegin(), ie = rend(); $noteq_reverse_iterator$C(it, ie); it.$preInc())  {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0) || (it.$star()).getOption().matches(/*NO_COPY*/Id1)
              || (it.$star()).getOption().matches(/*NO_COPY*/Id2) || (it.$star()).getOption().matches(/*NO_COPY*/Id3)) {
        return it.$star();
      }
    }
    return null;
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 84,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 66,
   FQN="llvm::opt::ArgList::getLastArg", NM="_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierE")
  //</editor-fold>
  public Arg /*P*/ getLastArg(OptSpecifier Id) /*const*/ {
    Arg /*P*/ Res = null;
    for (type$ptr<Arg /*P*//*,16*/>  it = begin(), ie = end(); $noteq_iter(it, ie); it.$preInc()) {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id)) {
        Res = it.$star();
        Res.claim();
      }
    }
    
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 96,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 78,
   FQN="llvm::opt::ArgList::getLastArg", NM="_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_")
  //</editor-fold>
  public Arg /*P*/ getLastArg(OptSpecifier Id0, OptSpecifier Id1) /*const*/ {
    Arg /*P*/ Res = null;
    for (type$ptr<Arg /*P*//*,16*/>  it = begin(), ie = end(); $noteq_iter(it, ie); it.$preInc()) {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id1)) {
        Res = it.$star();
        Res.claim();
      }
    }
    
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 110,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 92,
   FQN="llvm::opt::ArgList::getLastArg", NM="_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_")
  //</editor-fold>
  public Arg /*P*/ getLastArg(OptSpecifier Id0, OptSpecifier Id1, 
            OptSpecifier Id2) /*const*/ {
    Arg /*P*/ Res = null;
    for (type$ptr<Arg /*P*//*,16*/>  it = begin(), ie = end(); $noteq_iter(it, ie); it.$preInc()) {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id1)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id2)) {
        Res = it.$star();
        Res.claim();
      }
    }
    
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 125,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 107,
   FQN="llvm::opt::ArgList::getLastArg", NM="_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_")
  //</editor-fold>
  public Arg /*P*/ getLastArg(OptSpecifier Id0, OptSpecifier Id1, 
          OptSpecifier Id2, OptSpecifier Id3) /*const*/ {
    Arg /*P*/ Res = null;
    for (type$ptr<Arg /*P*//*,16*/>  it = begin(), ie = end(); $noteq_iter(it, ie); it.$preInc()) {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id1)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id2)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id3)) {
        Res = it.$star();
        Res.claim();
      }
    }
    
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 141,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 123,
   FQN="llvm::opt::ArgList::getLastArg", NM="_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_S2_")
  //</editor-fold>
  public Arg /*P*/ getLastArg(OptSpecifier Id0, OptSpecifier Id1,
          OptSpecifier Id2, OptSpecifier Id3, 
          OptSpecifier Id4) /*const*/ {
    Arg /*P*/ Res = null;
    for (type$ptr<Arg /*P*//*,16*/>  it = begin(), ie = end(); $noteq_iter(it, ie); it.$preInc()) {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id1)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id2)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id3)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id4)) {
        Res = it.$star();
        Res.claim();
      }
    }
    
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 159,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 141,
   FQN="llvm::opt::ArgList::getLastArg", NM="_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_S2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_S2_S2_")
  //</editor-fold>
  public Arg /*P*/ getLastArg(OptSpecifier Id0, OptSpecifier Id1, 
          OptSpecifier Id2, OptSpecifier Id3, 
          OptSpecifier Id4, OptSpecifier Id5) /*const*/ {
    Arg /*P*/ Res = null;
    for (type$ptr<Arg /*P*//*,16*/>  it = begin(), ie = end(); $noteq_iter(it, ie); it.$preInc()) {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id1)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id2)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id3)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id4)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id5)) {
        Res = it.$star();
        Res.claim();
      }
    }
    
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 178,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 160,
   FQN="llvm::opt::ArgList::getLastArg", NM="_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_S2_S2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_S2_S2_S2_")
  //</editor-fold>
  public Arg /*P*/ getLastArg(OptSpecifier Id0, OptSpecifier Id1, 
          OptSpecifier Id2, OptSpecifier Id3, 
          OptSpecifier Id4, OptSpecifier Id5, 
          OptSpecifier Id6) /*const*/ {
    Arg /*P*/ Res = null;
    for (type$ptr<Arg /*P*//*,16*/>  it = begin(), ie = end(); $noteq_iter(it, ie); it.$preInc()) {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id1)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id2)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id3)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id4)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id5)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id6)) {
        Res = it.$star();
        Res.claim();
      }
    }
    
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 199,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 181,
   FQN="llvm::opt::ArgList::getLastArg", NM="_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_S2_S2_S2_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10getLastArgENS0_12OptSpecifierES2_S2_S2_S2_S2_S2_S2_")
  //</editor-fold>
  public Arg /*P*/ getLastArg(OptSpecifier Id0, OptSpecifier Id1, 
          OptSpecifier Id2, OptSpecifier Id3, 
          OptSpecifier Id4, OptSpecifier Id5, 
          OptSpecifier Id6, OptSpecifier Id7) /*const*/ {
    Arg /*P*/ Res = null;
    for (type$ptr<Arg /*P*//*,16*/>  it = begin(), ie = end(); $noteq_iter(it, ie); it.$preInc()) {
      if ((it.$star()).getOption().matches(/*NO_COPY*/Id0)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id1)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id2)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id3)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id4)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id5)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id6)
         || (it.$star()).getOption().matches(/*NO_COPY*/Id7)) {
        Res = it.$star();
        Res.claim();
      }
    }
    
    return Res;
  }

  
  /// getArgString - Return the input argument string at \p Index.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getArgString">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 221,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 208,
   FQN = "llvm::opt::ArgList::getArgString", NM = "_ZNK4llvm3opt7ArgList12getArgStringEj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList12getArgStringEj")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/char$ptr/*char P*/ getArgString(/*uint*/int Index) /*const*//* = 0*/;

  
  /// getNumInputArgStrings - Return the number of original argument strings,
  /// which are guaranteed to be the first strings in the argument string
  /// list.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getNumInputArgStrings">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", old_line = 213,
   FQN = "llvm::opt::ArgList::getNumInputArgStrings", NM = "_ZNK4llvm3opt7ArgList21getNumInputArgStringsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList21getNumInputArgStringsEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getNumInputArgStrings() /*const*//* = 0*/;

  
  /// @}
  /// @name Argument Lookup Utilities
  /// @{
  
  /// getLastArgValue - Return the value of the last argument, or a default.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getLastArgValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 234,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 216,
   FQN = "llvm::opt::ArgList::getLastArgValue", NM = "_ZNK4llvm3opt7ArgList15getLastArgValueENS0_12OptSpecifierENS_9StringRefE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList15getLastArgValueENS0_12OptSpecifierENS_9StringRefE")
  //</editor-fold>
  public StringRef getLastArgValue(OptSpecifier Id) /*const*/ {
    return getLastArgValue(Id, 
                 new StringRef(/*KEEP_STR*/$EMPTY));
  }
  public StringRef getLastArgValue(OptSpecifier Id, 
          StringRef Default/*= ""*/) /*const*/ {
    {
      Arg /*P*/ A = getLastArg(/*NO_COPY*/Id);
      if ((A != null)) {
        return new StringRef(A.getValue());
      }
    }
    return Default; // do we really need generated return new StringRef(JD$Move.INSTANCE, Default);
  }

  
  /// getAllArgValues - Get the values of all instances of the given argument
  /// as strings.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::getAllArgValues">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 241,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 223,
   FQN="llvm::opt::ArgList::getAllArgValues", NM="_ZNK4llvm3opt7ArgList15getAllArgValuesENS0_12OptSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList15getAllArgValuesENS0_12OptSpecifierE")
  //</editor-fold>
  public std.vectorString getAllArgValues(OptSpecifier Id) /*const*/ {
    ArgStringList Values = new ArgStringList();
    AddAllArgValues(Values, /*NO_COPY*/Id);
      return new std.vectorString(Values.begin(), Values.end(), std.string.EMPTY);
    }

  
  /// @}
  /// @name Translation Utilities
  /// @{
  
  /// hasFlag - Given an option \p Pos and its negative form \p Neg, return
  /// true if the option is present, false if the negation is present, and
  /// \p Default if neither option is given. If both the option and its
  /// negation are present, the last one wins.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::hasFlag">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 221,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 203,
   FQN="llvm::opt::ArgList::hasFlag", NM="_ZNK4llvm3opt7ArgList7hasFlagENS0_12OptSpecifierES2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList7hasFlagENS0_12OptSpecifierES2_b")
  //</editor-fold>
  public boolean hasFlag(OptSpecifier Pos, OptSpecifier Neg) /*const*/ {
    return hasFlag(Pos, Neg, true);
  }
  public boolean hasFlag(OptSpecifier Pos, OptSpecifier Neg, boolean Default/*= true*/) /*const*/ {
    {
      Arg /*P*/ A = getLastArg(/*NO_COPY*/Pos, /*NO_COPY*/Neg);
      if ((A != null)) {
        return A.getOption().matches(/*NO_COPY*/Pos);
      }
    }
    return Default;
  }

  
  /// hasFlag - Given an option \p Pos, an alias \p PosAlias and its negative
  /// form \p Neg, return true if the option or its alias is present, false if
  /// the negation is present, and \p Default if none of the options are
  /// given. If multiple options are present, the last one wins.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::hasFlag">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 227,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 209,
   FQN="llvm::opt::ArgList::hasFlag", NM="_ZNK4llvm3opt7ArgList7hasFlagENS0_12OptSpecifierES2_S2_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList7hasFlagENS0_12OptSpecifierES2_S2_b")
  //</editor-fold>
  public boolean hasFlag(OptSpecifier Pos, OptSpecifier PosAlias, OptSpecifier Neg) /*const*/ {
    return hasFlag(Pos, PosAlias, Neg, 
            true);
  }
  public boolean hasFlag(OptSpecifier Pos, OptSpecifier PosAlias, OptSpecifier Neg, 
          boolean Default/*= true*/) /*const*/ {
    {
      Arg /*P*/ A = getLastArg(/*NO_COPY*/Pos, /*NO_COPY*/PosAlias, /*NO_COPY*/Neg);
      if ((A != null)) {
        return A.getOption().matches(/*NO_COPY*/Pos) || A.getOption().matches(/*NO_COPY*/PosAlias);
      }
    }
    return Default;
  }

  
  /// AddLastArg - Render only the last argument match \p Id0, if present.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::AddLastArg">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 247,
            old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 229,
   FQN="llvm::opt::ArgList::AddLastArg", NM="_ZNK4llvm3opt7ArgList10AddLastArgERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10AddLastArgERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierE")
  //</editor-fold>
  public void AddLastArg(ArgStringList/*&*/ Output, OptSpecifier Id) /*const*/ {
    {
      Arg /*P*/ A = getLastArg(/*NO_COPY*/Id);
      if ((A != null)) {
        A.claim();
        A.render(/*Deref*/this, Output);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::AddLastArg">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 254,
          old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 236,
   FQN="llvm::opt::ArgList::AddLastArg", NM="_ZNK4llvm3opt7ArgList10AddLastArgERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10AddLastArgERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierES7_")
//</editor-fold>
  public void AddLastArg(ArgStringList/*&*/ Output, OptSpecifier Id0,
          OptSpecifier Id1) /*const*/ {
    {
      Arg /*P*/ A = getLastArg(/*NO_COPY*/Id0, /*NO_COPY*/Id1);
      if ((A != null)) {
        A.claim();
        A.render(/*Deref*/this, Output);
      }
    }
  }

  
  /// AddAllArgs - Render all arguments matching any of the given ids.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::AddAllArgs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 262,
   FQN="llvm::opt::ArgList::AddAllArgs", NM="_ZNK4llvm3opt7ArgList10AddAllArgsERNS_11SmallVectorIPKcLj16EEENS_8ArrayRefINS0_12OptSpecifierEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10AddAllArgsERNS_11SmallVectorIPKcLj16EEENS_8ArrayRefINS0_12OptSpecifierEEE")
  //</editor-fold>
  public void AddAllArgs(ArgStringList/*&*/ Output, 
            ArrayRef<OptSpecifier> Ids) /*const*/ {
    for (/*const*/ Arg /*P*/ Arg : Args) {
      for (OptSpecifier Id : Ids) {
        if (Arg.getOption().matches(/*NO_COPY*/Id)) {
          Arg.claim();
          Arg.render(/*Deref*/this, Output);
          break;
        }
      }
    }
  }

  
  /// AddAllArgs - Render all arguments matching the given ids.
  
  /// This 3-opt variant of AddAllArgs could be eliminated in favor of one
  /// that accepts a single specifier, given the above which accepts any number.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::AddAllArgs">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 277,
            old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 244,
   FQN="llvm::opt::ArgList::AddAllArgs", NM="_ZNK4llvm3opt7ArgList10AddAllArgsERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierES7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList10AddAllArgsERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierES7_S7_")
  //</editor-fold>
  public void AddAllArgs(ArgStringList/*&*/ Output, OptSpecifier Id0) /*const*/ {
    AddAllArgs(Output, Id0,
            new OptSpecifier(0/*U*/), new OptSpecifier(0/*U*/));
  }
  public void AddAllArgs(ArgStringList/*&*/ Output, OptSpecifier Id0,
          OptSpecifier Id1/*= 0UU*/) /*const*/ {
    AddAllArgs(Output, Id0,
            Id1, new OptSpecifier(0/*U*/));
  }
  public void AddAllArgs(ArgStringList/*&*/ Output, OptSpecifier Id0,
          OptSpecifier Id1/*= 0UU*/, OptSpecifier Id2/*= 0UU*/) /*const*/ {
    for (Arg /*P*/ Arg : filtered(/*NO_COPY*/Id0, /*NO_COPY*/Id1, /*NO_COPY*/Id2)) {
      Arg.claim();
      Arg.render(/*Deref*/this, Output);
    }
  }
  
  
/// AddAllArgValues - Render the argument values of all arguments
/// matching the given ids.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::AddAllArgValues">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 285,
          old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 252,
   FQN="llvm::opt::ArgList::AddAllArgValues", NM="_ZNK4llvm3opt7ArgList15AddAllArgValuesERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierES7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList15AddAllArgValuesERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierES7_S7_")
//</editor-fold>
  public void AddAllArgValues(ArgStringList/*&*/ Output, OptSpecifier Id0) /*const*/ {
    AddAllArgValues(Output, Id0,
            new OptSpecifier(0/*U*/), new OptSpecifier(0/*U*/));
  }
  public void AddAllArgValues(ArgStringList/*&*/ Output, OptSpecifier Id0,
          OptSpecifier Id1/*= 0UU*/) /*const*/ {
    AddAllArgValues(Output, Id0,
            Id1, new OptSpecifier(0/*U*/));
  }
  public void AddAllArgValues(ArgStringList/*&*/ Output, OptSpecifier Id0,
          OptSpecifier Id1/*= 0UU*/, OptSpecifier Id2/*= 0UU*/) /*const*/ {
    for (Arg /*P*/ Arg : filtered(/*NO_COPY*/Id0, /*NO_COPY*/Id1, /*NO_COPY*/Id2)) {
      Arg.claim();
      /*const*/ SmallVectorImpl</*const*/char$ptr/*char P*/ > /*&*/ Values = Arg.getValues();
      Output.append_T(Values.begin(), Values.end());
    }
  }


/// AddAllArgsTranslated - Render all the arguments matching the
/// given ids, but forced to separate args and using the provided
/// name instead of the first option value.
///
/// \param Joined - If true, render the argument as joined with
/// the option specifier.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::AddAllArgsTranslated">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 294,
     old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 261,
   FQN="llvm::opt::ArgList::AddAllArgsTranslated", NM="_ZNK4llvm3opt7ArgList20AddAllArgsTranslatedERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierES4_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList20AddAllArgsTranslatedERNS_11SmallVectorIPKcLj16EEENS0_12OptSpecifierES4_b")
//</editor-fold>
  public void AddAllArgsTranslated(ArgStringList/*&*/ Output, OptSpecifier Id0, 
                      /*const*/char$ptr/*char P*/ Translation) /*const*/ {
        AddAllArgsTranslated(Output, Id0,
                Translation,
                false);
    }
  public void AddAllArgsTranslated(ArgStringList/*&*/ Output, OptSpecifier Id0, 
                      /*const*/char$ptr/*char P*/ Translation, 
            boolean Joined/*= false*/) /*const*/ {
    for (Arg /*P*/ Arg : filtered(/*NO_COPY*/Id0)) {
            Arg.claim();
            if (Joined) {
                Output.push_back(MakeArgString($add_StringRef_T(new StringRef(Translation),
                        Arg.getValue(0))));
            } else {
                Output.push_back(Translation);
                Output.push_back(Arg.getValue(0));
            }
        }
    }
    

/// ClaimAllArgs - Claim all arguments which match the given
/// option id.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::ClaimAllArgs">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 310,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 277,
   FQN="llvm::opt::ArgList::ClaimAllArgs", NM="_ZNK4llvm3opt7ArgList12ClaimAllArgsENS0_12OptSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList12ClaimAllArgsENS0_12OptSpecifierE")
//</editor-fold>
  public void ClaimAllArgs(OptSpecifier Id0) /*const*/ {
    for (Arg /*P*/ Arg : filtered(/*NO_COPY*/Id0))  {
      Arg.claim();
    }
  }

  
  /// ClaimAllArgs - Claim all arguments.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::ClaimAllArgs">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 315,
     old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 282,
   FQN="llvm::opt::ArgList::ClaimAllArgs", NM="_ZNK4llvm3opt7ArgList12ClaimAllArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList12ClaimAllArgsEv")
  //</editor-fold>
  public void ClaimAllArgs() /*const*/ {
    for (type$ptr<Arg /*P*//*,16*/>  it = begin(), ie = end(); $noteq_iter(it, ie); it.$preInc())  {
      if (!(it.$star()).isClaimed()) {
        (it.$star()).claim();
      }
    }
  }

  
  /// @}
  /// @name Arg Synthesis
  /// @{
  
  /// Construct a constant string pointer whose
  /// lifetime will match that of the ArgList.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::MakeArgStringRef">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 298,
   FQN="llvm::opt::ArgList::MakeArgStringRef", NM="_ZNK4llvm3opt7ArgList16MakeArgStringRefENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList16MakeArgStringRefENS_9StringRefE")
  //</editor-fold>
  public abstract /*virtual*/ /*const*/char$ptr/*char P*/ MakeArgStringRef(StringRef Str) /*const*//* = 0*/;

  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED) // in native, char* is implicitely converted to twine
  public final /*const*/char$ptr/*char P*/ MakeArgString(StringRef Str) /*const*/ {
    return MakeArgStringRef(Str);
  }

  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED) // in native, char* is implicitely converted to twine
  public final /*const*/char$ptr/*char P*/ MakeArgString(/*const*/char$ptr/*char P*/ Str) /*const*/ {
    return MakeArgStringRef(new StringRef(Str));
  }

  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED) // in native, char* is implicitely converted to twine
  public final /*const*/char$ptr/*char P*/ MakeArgString(/*const*/String/*char P*/ Str) /*const*/ {
    return MakeArgStringRef(new StringRef(Str));
  }

  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED) // in native, char* is implicitely converted to twine
  public final /*const*/char$ptr/*char P*/ MakeArgString(std.string Str) /*const*/ {
    return MakeArgStringRef(new StringRef(Str));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::MakeArgString">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Option/ArgList.h", line = 299,
          old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 288,
   FQN="llvm::opt::ArgList::MakeArgString", NM="_ZNK4llvm3opt7ArgList13MakeArgStringERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList13MakeArgStringERKNS_5TwineE")
//</editor-fold>
  public /*const*/char$ptr/*char P*/ MakeArgString(/*const*/ Twine /*&*/ Str) /*const*/ {
    SmallString/*256*/ Buf/*J*/= new SmallString/*256*/(256);
    return MakeArgStringRef(Str.toStringRef(Buf));
  }

  
  /// \brief Create an arg string for (\p LHS + \p RHS), reusing the
  /// string at \p Index if possible.
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::GetOrMakeJoinedArgString">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 321,
   old_source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", old_line = 293,
   FQN="llvm::opt::ArgList::GetOrMakeJoinedArgString", NM="_ZNK4llvm3opt7ArgList24GetOrMakeJoinedArgStringEjNS_9StringRefES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList24GetOrMakeJoinedArgStringEjNS_9StringRefES2_")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ GetOrMakeJoinedArgString(/*uint*/int Index, 
          StringRef LHS, 
          StringRef RHS) /*const*/ {
    StringRef Cur = new StringRef(getArgString(Index));
    if (Cur.size() == LHS.size() + RHS.size() 
       && Cur.startswith(/*NO_COPY*/LHS) && Cur.endswith(/*NO_COPY*/RHS)) {
      return Cur.data();
    }
    
    return MakeArgString($add_Twine(new Twine(LHS), new Twine(RHS)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::print">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 332,
   FQN="llvm::opt::ArgList::print", NM="_ZNK4llvm3opt7ArgList5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList5printERNS_11raw_ostreamE")
//</editor-fold>
  public void print(raw_ostream /*&*/ O) /*const*/ {
    for (Arg /*P*/ A : /*Deref*/this) {
      O.$out(/*KEEP_STR*/"* ");
      A.print(O);
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::opt::ArgList::dump">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/ArgList.cpp", line = 339,
   FQN="llvm::opt::ArgList::dump", NM="_ZNK4llvm3opt7ArgList4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/ArgList.cpp -nm=_ZNK4llvm3opt7ArgList4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
  }

  @Override
  public Iterator<Arg> iterator() {
    return Args.iterator();
  }

/// @}
  @Override
  public String toString() {
    return "Args=" + Args;
  }
}
