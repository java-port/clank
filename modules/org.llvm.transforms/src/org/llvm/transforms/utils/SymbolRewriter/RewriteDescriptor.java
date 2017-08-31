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

package org.llvm.transforms.utils.SymbolRewriter;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;

/// The basic entity representing a rewrite operation.  It serves as the base
/// class for any rewrite descriptor.  It has a certain set of specializations
/// which describe a particular rewrite.
///
/// The RewriteMapParser can be used to parse a mapping file that provides the
/// mapping for rewriting the symbols.  The descriptors individually describe
/// whether to rewrite a function, global variable, or global alias.  Each of
/// these can be selected either by explicitly providing a name for the ones to
/// be rewritten or providing a (posix compatible) regular expression that will
/// select the symbols to rewrite.  This descriptor list is passed to the
/// SymbolRewriter pass.
//<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteDescriptor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 62,
 FQN="llvm::SymbolRewriter::RewriteDescriptor", NM="_ZN4llvm14SymbolRewriter17RewriteDescriptorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter17RewriteDescriptorE")
//</editor-fold>
public abstract class RewriteDescriptor implements /*public*/ ilist_node<RewriteDescriptor>, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteDescriptor::RewriteDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 63,
   FQN="llvm::SymbolRewriter::RewriteDescriptor::RewriteDescriptor", NM="_ZN4llvm14SymbolRewriter17RewriteDescriptorC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter17RewriteDescriptorC1ERKS1_")
  //</editor-fold>
  protected/*private*/ RewriteDescriptor(final /*const*/ RewriteDescriptor /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteDescriptor::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 65,
   FQN="llvm::SymbolRewriter::RewriteDescriptor::operator=", NM="_ZN4llvm14SymbolRewriter17RewriteDescriptoraSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter17RewriteDescriptoraSERKS1_")
  //</editor-fold>
  protected/*private*/ /*const*/ RewriteDescriptor /*&*/ $assign(final /*const*/ RewriteDescriptor /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteDescriptor::Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 69,
   FQN="llvm::SymbolRewriter::RewriteDescriptor::Type", NM="_ZN4llvm14SymbolRewriter17RewriteDescriptor4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter17RewriteDescriptor4TypeE")
  //</editor-fold>
  public enum /*class */Type/* : int*/ implements Native.NativeIntEnum {
    Invalid(0), /// invalid
    Function(Invalid.getValue() + 1), /// function - descriptor rewrites a function
    GlobalVariable(Function.getValue() + 1), /// global variable - descriptor rewrites a global variable
    NamedAlias(GlobalVariable.getValue() + 1); /// named alias - descriptor rewrites a global alias

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Type valueOf(int val) {
      Type out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Type[] VALUES;
      private static final Type[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Type kind : Type.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Type[min < 0 ? (1-min) : 0];
        VALUES = new Type[max >= 0 ? (1+max) : 0];
        for (Type kind : Type.values()) {
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

    private final int value;
    private Type(int val) { this.value = (int)val;}
    @Override public final int getValue() { return value;}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteDescriptor::~RewriteDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 76,
   FQN="llvm::SymbolRewriter::RewriteDescriptor::~RewriteDescriptor", NM="_ZN4llvm14SymbolRewriter17RewriteDescriptorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter17RewriteDescriptorD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    ilist_node.super.$destroy$ilist_node();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteDescriptor::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 78,
   FQN="llvm::SymbolRewriter::RewriteDescriptor::getType", NM="_ZNK4llvm14SymbolRewriter17RewriteDescriptor7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZNK4llvm14SymbolRewriter17RewriteDescriptor7getTypeEv")
  //</editor-fold>
  public Type getType() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteDescriptor::performOnModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 80,
   FQN="llvm::SymbolRewriter::RewriteDescriptor::performOnModule", NM="_ZN4llvm14SymbolRewriter17RewriteDescriptor15performOnModuleERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter17RewriteDescriptor15performOnModuleERNS_6ModuleE")
  //</editor-fold>
  public abstract /*virtual*/ boolean performOnModule(final Module /*&*/ M)/* = 0*/;

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SymbolRewriter::RewriteDescriptor::RewriteDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SymbolRewriter.h", line = 83,
   FQN="llvm::SymbolRewriter::RewriteDescriptor::RewriteDescriptor", NM="_ZN4llvm14SymbolRewriter17RewriteDescriptorC1ENS1_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm14SymbolRewriter17RewriteDescriptorC1ENS1_4TypeE")
  //</editor-fold>
  protected /*explicit*/ RewriteDescriptor(Type T) {
    // : ilist_node<RewriteDescriptor>(), Kind(T) 
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this.Kind = T;
    //END JInit
  }

/*private:*/
  private /*const*/ Type Kind;
  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  /*package*/static RewriteDescriptor $createSentinel() {
    return new RewriteDescriptorSentinel();
  }
  
  private static final class RewriteDescriptorSentinel extends RewriteDescriptor {

    public RewriteDescriptorSentinel() {
      super(Type.Invalid);
    }
    
    @Override
    public boolean performOnModule(Module M) {
      throw new IllegalStateException("Not supported in sentinels.");
    }
  }
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + super.toString(); // NOI18N
  }
}
