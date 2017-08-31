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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import org.llvm.adt.java.TrailingObjectsUtils;


/// \brief A template argument list.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 173,
 FQN="clang::TemplateArgumentList", NM="_ZN5clang20TemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateArgumentListE")
//</editor-fold>
public final class TemplateArgumentList implements /*private*/ TrailingObjects<TemplateArgumentList, TemplateArgument> {
  /// \brief The template argument list.
  private /*const*/type$ptr<TemplateArgument/*P*/> Arguments;
  
  /// \brief The number of template arguments in this template
  /// argument list.
  private /*uint*/int NumArguments;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::TemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 182,
   FQN="clang::TemplateArgumentList::TemplateArgumentList", NM="_ZN5clang20TemplateArgumentListC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateArgumentListC1ERKS0_")
  //</editor-fold>
  private TemplateArgumentList(final /*const*/ TemplateArgumentList /*&*/ Other) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 183,
   FQN="clang::TemplateArgumentList::operator=", NM="_ZN5clang20TemplateArgumentListaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateArgumentListaSERKS0_")
  //</editor-fold>
  private void $assign(final /*const*/ TemplateArgumentList /*&*/ Other) { throw new UnsupportedOperationException("Deleted");}

  
  // Constructs an instance with an internal Argument list, containing
  // a copy of the Args array. (Called by CreateCopy)
  
  //===----------------------------------------------------------------------===//
  // TemplateArgumentList Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::TemplateArgumentList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$this*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 663,
   FQN="clang::TemplateArgumentList::TemplateArgumentList", NM="_ZN5clang20TemplateArgumentListC1EN4llvm8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateArgumentListC1EN4llvm8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  private TemplateArgumentList(type$ptr<?> $this, ArrayRef<TemplateArgument> Args) {
    // : TrailingObjects<TemplateArgumentList, TemplateArgument>(), Arguments(getTrailingObjects<TemplateArgument>()), NumArguments(Args.size()) 
    //START JInit
    $TrailingObjects();
    //JAVA: avoid using trailing objects
    this.Arguments = (type$ptr) TrailingObjectsUtils.$putThisAndShift(this, $this); // $tryClone(getTrailingObjects(TemplateArgument.class));
    this.NumArguments = Args.size();
    //END JInit
    //JAVA: avoid using trailing objects
    std.uninitialized_copy(Args.begin(), Args.end(), 
        this.Arguments /*getTrailingObjects(TemplateArgument.class)*/);
  }

/*public:*/
  /// \brief Type used to indicate that the template argument list itself is a
  /// stack object. It does not own its template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::OnStackType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 192,
   FQN="clang::TemplateArgumentList::OnStackType", NM="_ZN5clang20TemplateArgumentList11OnStackTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateArgumentList11OnStackTypeE")
  //</editor-fold>
  public enum OnStackType implements Native.ComparableLower {
    OnStack(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OnStackType valueOf(int val) {
      OnStackType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final OnStackType[] VALUES;
      private static final OnStackType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OnStackType kind : OnStackType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OnStackType[min < 0 ? (1-min) : 0];
        VALUES = new OnStackType[max >= 0 ? (1+max) : 0];
        for (OnStackType kind : OnStackType.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private OnStackType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((OnStackType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((OnStackType)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Create a new template argument list that copies the given set of
  /// template arguments.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::CreateCopy">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*constructor*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 670,
   FQN="clang::TemplateArgumentList::CreateCopy", NM="_ZN5clang20TemplateArgumentList10CreateCopyERNS_10ASTContextEN4llvm8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateArgumentList10CreateCopyERNS_10ASTContextEN4llvm8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public static TemplateArgumentList /*P*/ CreateCopy(final ASTContext /*&*/ Context, 
            ArrayRef<TemplateArgument> Args) {
    Object/*void P*/ Mem;
    if (false) {
      Mem = Context.Allocate(TrailingObjects.totalSizeToAlloc$Same(TemplateArgument.class, Args.size()));
    } else {
      Mem = Context.Allocate$JavaRef(TrailingObjects.totalSizeToAlloc$Same(TemplateArgument.class, Args.size()));
    }
    return new TemplateArgumentList((type$ptr<?>) Mem, new ArrayRef<TemplateArgument>(Args));
  }

  
  /// \brief Construct a new, temporary template argument list on the stack.
  ///
  /// The template argument list does not own the template arguments
  /// provided.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::TemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 203,
   FQN="clang::TemplateArgumentList::TemplateArgumentList", NM="_ZN5clang20TemplateArgumentListC1ENS0_11OnStackTypeEN4llvm8ArrayRefINS_16TemplateArgumentEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateArgumentListC1ENS0_11OnStackTypeEN4llvm8ArrayRefINS_16TemplateArgumentEEE")
  //</editor-fold>
  public /*explicit*/ TemplateArgumentList(OnStackType $Prm0, ArrayRef<TemplateArgument> Args) {
    // : TrailingObjects<TemplateArgumentList, TemplateArgument>(), Arguments(Args.data()), NumArguments(Args.size()) 
    //START JInit
    $TrailingObjects();
    this.Arguments = $tryClone(Args.data());
    this.NumArguments = Args.size();
    //END JInit
  }

  
  /// \brief Produces a shallow copy of the given template argument list.
  ///
  /// This operation assumes that the input argument list outlives it.
  /// This takes the list as a pointer to avoid looking like a copy
  /// constructor, since this really really isn't safe to use that
  /// way.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::TemplateArgumentList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 212,
   FQN="clang::TemplateArgumentList::TemplateArgumentList", NM="_ZN5clang20TemplateArgumentListC1EPKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang20TemplateArgumentListC1EPKS0_")
  //</editor-fold>
  public /*explicit*/ TemplateArgumentList(JD$TemplateArgumentList$C$P _dparam, /*const*/ TemplateArgumentList /*P*/ Other) {
    // : TrailingObjects<TemplateArgumentList, TemplateArgument>(), Arguments(Other->data()), NumArguments(Other->size()) 
    //START JInit
    $TrailingObjects();
    this.Arguments = $tryClone(Other.data());
    this.NumArguments = Other.size();
    //END JInit
  }

  
  /// \brief Retrieve the template argument at a given index.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 216,
   FQN="clang::TemplateArgumentList::get", NM="_ZNK5clang20TemplateArgumentList3getEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateArgumentList3getEj")
  //</editor-fold>
  public /*const*/ TemplateArgument /*&*/ get(/*uint*/int Idx) /*const*/ {
    assert ($less_uint(Idx, NumArguments)) : "Invalid template argument index";
    return data().$at(Idx);
  }

  
  /// \brief Retrieve the template argument at a given index.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 222,
   FQN="clang::TemplateArgumentList::operator[]", NM="_ZNK5clang20TemplateArgumentListixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateArgumentListixEj")
  //</editor-fold>
  public /*const*/ TemplateArgument /*&*/ $at(/*uint*/int Idx) /*const*/ {
    return get(Idx);
  }

  
  /// \brief Produce this as an array ref.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::asArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 225,
   FQN="clang::TemplateArgumentList::asArray", NM="_ZNK5clang20TemplateArgumentList7asArrayEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateArgumentList7asArrayEv")
  //</editor-fold>
  public ArrayRef<TemplateArgument> asArray() /*const*/ {
    return llvm.makeArrayRef(data(), size());
  }

  
  /// \brief Retrieve the number of template arguments in this
  /// template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 231,
   FQN="clang::TemplateArgumentList::size", NM="_ZNK5clang20TemplateArgumentList4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateArgumentList4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumArguments;
  }

  
  /// \brief Retrieve a pointer to the template argument list.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateArgumentList::data">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 234,
   FQN="clang::TemplateArgumentList::data", NM="_ZNK5clang20TemplateArgumentList4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang20TemplateArgumentList4dataEv")
  //</editor-fold>
  public /*const*/type$ptr<TemplateArgument/*P*/> data() /*const*/ {
    return Arguments;
  }

  
  /*friend  TrailingObjects<TemplateArgumentList, TemplateArgument>*/
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public int getTrailingObjects$Offset(Class<?> clazz) { assert clazz == TemplateArgument.class; return 0; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Arguments=" + Arguments // NOI18N
              + ", NumArguments=" + NumArguments // NOI18N
              + super.toString(); // NOI18N
  }
}
