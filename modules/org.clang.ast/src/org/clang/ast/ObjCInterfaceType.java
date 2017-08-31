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


/// Interfaces are the core concept in Objective-C for object oriented design.
/// They basically correspond to C++ classes.  There are two kinds of interface
/// types: normal interfaces like `NSString`, and qualified interfaces, which
/// are qualified with a protocol list like `NSString<NSCopyable, NSAmazing>`.
///
/// ObjCInterfaceType guarantees the following properties when considered
/// as a subtype of its superclass, ObjCObjectType:
///   - There are no protocol qualifiers.  To reinforce this, code which
///     tries to invoke the protocol methods via an ObjCInterfaceType will
///     fail to compile.
///   - It is its own base type.  That is, if T is an ObjCInterfaceType*,
///     T->getBaseType() == QualType(T, 0).
//<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4936,
 FQN="clang::ObjCInterfaceType", NM="_ZN5clang17ObjCInterfaceTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ObjCInterfaceTypeE")
//</editor-fold>
public class ObjCInterfaceType extends /*public*/ ObjCObjectType {
  /*friend*/public/*private*/ /*mutable */ObjCInterfaceDecl /*P*/ Decl;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceType::ObjCInterfaceType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4939,
   FQN="clang::ObjCInterfaceType::ObjCInterfaceType", NM="_ZN5clang17ObjCInterfaceTypeC1EPKNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ObjCInterfaceTypeC1EPKNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  /*friend*/protected/*private*/ ObjCInterfaceType(/*const*/ ObjCInterfaceDecl /*P*/ D) {
    // : ObjCObjectType(Nonce_ObjCInterface), Decl(const_cast<ObjCInterfaceDecl * >(D)) 
    //START JInit
    super(Nonce_ObjCInterface.Nonce_ObjCInterface);
    this.Decl = ((/*const_cast*/ObjCInterfaceDecl /*P*/ )(D));
    //END JInit
  }

  /*friend  class ASTContext*/ // ASTContext creates these.
  /*friend  class ASTReader*/
  /*friend  class ObjCInterfaceDecl*/
/*public:*/
  /// Get the declaration of this interface.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceType::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4948,
   FQN="clang::ObjCInterfaceType::getDecl", NM="_ZNK5clang17ObjCInterfaceType7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17ObjCInterfaceType7getDeclEv")
  //</editor-fold>
  public ObjCInterfaceDecl /*P*/ getDecl() /*const*/ {
    return Decl;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceType::isSugared">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4950,
   FQN="clang::ObjCInterfaceType::isSugared", NM="_ZNK5clang17ObjCInterfaceType9isSugaredEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17ObjCInterfaceType9isSugaredEv")
  //</editor-fold>
  public boolean isSugared() /*const*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceType::desugar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4951,
   FQN="clang::ObjCInterfaceType::desugar", NM="_ZNK5clang17ObjCInterfaceType7desugarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZNK5clang17ObjCInterfaceType7desugarEv")
  //</editor-fold>
  public QualType desugar() /*const*/ {
    return new QualType(this, 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4953,
   FQN="clang::ObjCInterfaceType::classof", NM="_ZN5clang17ObjCInterfaceType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ObjCInterfaceType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.ObjCInterface;
  }

  
  // Nonsense to "hide" certain members of ObjCObjectType within this
  // class.  People asking for protocols on an ObjCInterfaceType are
  // not going to get what they want: ObjCInterfaceTypes are
  // guaranteed to have no protocols.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCInterfaceType::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 4961,
   FQN="clang::ObjCInterfaceType::(anonymous)", NM="_ZN5clang17ObjCInterfaceTypeE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZN5clang17ObjCInterfaceTypeE_Unnamed_enum")
  //</editor-fold>
  public enum Unnamed_enum implements Native.ComparableLower {
    qual_iterator(0),
    qual_begin(qual_iterator.getValue() + 1),
    qual_end(qual_begin.getValue() + 1),
    getNumProtocols(qual_end.getValue() + 1),
    getProtocol(getNumProtocols.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  
  @Override public String toString() {
    std.string DeclName;
    try {
      DeclName = Decl.getNameAsString();
    } catch (Throwable e) {
      DeclName = new std.string();
    }
    return "" + "Decl=" + DeclName.toJavaString() + ":" + NativeTrace.getIdentityStr(Decl) // NOI18N
              + super.toString(); // NOI18N
  }
}
