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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief Represents a C++ template name within the type system.
///
/// A C++ template name refers to a template within the C++ type
/// system. In most cases, a template name is simply a reference to a
/// class template, e.g.
///
/// \code
/// template<typename T> class X { };
///
/// X<int> xi;
/// \endcode
///
/// Here, the 'X' in \c X<int> is a template name that refers to the
/// declaration of the class template X, above. Template names can
/// also refer to function templates, C++0x template aliases, etc.
///
/// Some template names are dependent. For example, consider:
///
/// \code
/// template<typename MetaFun, typename T1, typename T2> struct apply2 {
///   typedef typename MetaFun::template apply<T1, T2>::type type;
/// };
/// \endcode
///
/// Here, "apply" is treated as a template name within the typename
/// specifier in the typedef. "apply" is a nested template, and can
/// only be understood in the context of
//<editor-fold defaultstate="collapsed" desc="clang::TemplateName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 176,
 FQN="clang::TemplateName", NM="_ZN5clang12TemplateNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang12TemplateNameE")
//</editor-fold>
public class TemplateName {
  /*typedef llvm::PointerUnion4<TemplateDecl *, UncommonTemplateNameStorage *, QualifiedTemplateName *, DependentTemplateName *> StorageType*/
//  public final class StorageType extends PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >{ };
  
  private PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ > Storage;
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 54,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1EPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang12TemplateNameC1EPv")
  //</editor-fold>
  private TemplateName(Object/*void P*/ Ptr) {
    // : Storage() 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >(TemplateDecl /*P*/.class);
    //END JInit
    Storage.$assignMove(PointerUnion4.<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >getFromOpaqueValue(Ptr));
  }


/*public:*/
  // \brief Kind of name that is actually stored.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::NameKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 188,
   FQN="clang::TemplateName::NameKind", NM="_ZN5clang12TemplateName8NameKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang12TemplateName8NameKindE")
  //</editor-fold>
  public enum NameKind implements Native.ComparableLower {
    /// \brief A single template declaration.
    Template(0),
    /// \brief A set of overloaded template declarations.
    OverloadedTemplate(Template.getValue() + 1),
    /// \brief A qualified template name, where the qualification is kept 
    /// to describe the source code as written.
    QualifiedTemplate(OverloadedTemplate.getValue() + 1),
    /// \brief A dependent template name that has not been resolved to a 
    /// template (or set of templates).
    DependentTemplate(QualifiedTemplate.getValue() + 1),
    /// \brief A template template parameter that has been substituted
    /// for some other template name.
    SubstTemplateTemplateParm(DependentTemplate.getValue() + 1),
    /// \brief A template template parameter pack that has been substituted for 
    /// a template template argument pack, but has not yet been expanded into
    /// individual arguments.
    SubstTemplateTemplateParmPack(SubstTemplateTemplateParm.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NameKind valueOf(int val) {
      NameKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NameKind[] VALUES;
      private static final NameKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NameKind kind : NameKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NameKind[min < 0 ? (1-min) : 0];
        VALUES = new NameKind[max >= 0 ? (1+max) : 0];
        for (NameKind kind : NameKind.values()) {
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
    private NameKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NameKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NameKind)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 208,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang12TemplateNameC1Ev")
  //</editor-fold>
  public TemplateName() {
    // : Storage() 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >(TemplateDecl /*P*/.class);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 58,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1EPNS_12TemplateDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang12TemplateNameC1EPNS_12TemplateDeclE")
  //</editor-fold>
  public TemplateName(TemplateDecl /*P*/ Template) {
    // : Storage(Template) 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >(JD$T.INSTANCE, TemplateDecl /*P*/.class, Template);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 59,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1EPNS_25OverloadedTemplateStorageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang12TemplateNameC1EPNS_25OverloadedTemplateStorageE")
  //</editor-fold>
  public TemplateName(OverloadedTemplateStorage /*P*/ Storage) {
    // : Storage(Storage) 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >(JD$T1.INSTANCE, UncommonTemplateNameStorage /*P*/.class, Storage);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 61,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1EPNS_32SubstTemplateTemplateParmStorageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang12TemplateNameC1EPNS_32SubstTemplateTemplateParmStorageE")
  //</editor-fold>
  public TemplateName(SubstTemplateTemplateParmStorage /*P*/ Storage) {
    // : Storage(Storage) 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >(JD$T1.INSTANCE, UncommonTemplateNameStorage /*P*/.class, Storage);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 63,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1EPNS_36SubstTemplateTemplateParmPackStorageE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang12TemplateNameC1EPNS_36SubstTemplateTemplateParmPackStorageE")
  //</editor-fold>
  public TemplateName(SubstTemplateTemplateParmPackStorage /*P*/ Storage) {
    // : Storage(Storage) 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >(JD$T1.INSTANCE, UncommonTemplateNameStorage /*P*/.class, Storage);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 65,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1EPNS_21QualifiedTemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang12TemplateNameC1EPNS_21QualifiedTemplateNameE")
  //</editor-fold>
  public TemplateName(QualifiedTemplateName /*P*/ Qual) {
    // : Storage(Qual) 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >(JD$T2.INSTANCE, QualifiedTemplateName /*P*/.class, Qual);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 66,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1EPNS_21DependentTemplateNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clang12TemplateNameC1EPNS_21DependentTemplateNameE")
  //</editor-fold>
  public TemplateName(DependentTemplateName /*P*/ Dep) {
    // : Storage(Dep) 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >(JD$T3.INSTANCE, DependentTemplateName /*P*/.class, Dep);
    //END JInit
  }


  
  /// \brief Determine whether this template name is NULL.
  
  /// \brief Determine whether this template name is NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::isNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 68,
   FQN="clang::TemplateName::isNull", NM="_ZNK5clang12TemplateName6isNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName6isNullEv")
  //</editor-fold>
  public boolean isNull() /*const*/ {
    return Storage.isNull();
  }


  
  // \brief Get the kind of name that is actually stored.
  
  // \brief Get the kind of name that is actually stored.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 70,
   FQN="clang::TemplateName::getKind", NM="_ZNK5clang12TemplateName7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName7getKindEv")
  //</editor-fold>
  public TemplateName.NameKind getKind() /*const*/ {
    if ((Storage.is(TemplateDecl /*P*/.class) != 0)) {
      return NameKind.Template;
    }
    if ((Storage.is(DependentTemplateName /*P*/.class) != 0)) {
      return NameKind.DependentTemplate;
    }
    if ((Storage.is(QualifiedTemplateName /*P*/.class) != 0)) {
      return NameKind.QualifiedTemplate;
    }
    
    UncommonTemplateNameStorage /*P*/ uncommon = Storage.get(UncommonTemplateNameStorage /*P*/.class);
    if ((uncommon.getAsOverloadedStorage() != null)) {
      return NameKind.OverloadedTemplate;
    }
    if ((uncommon.getAsSubstTemplateTemplateParm() != null)) {
      return NameKind.SubstTemplateTemplateParm;
    }
    return NameKind.SubstTemplateTemplateParmPack;
  }


  
  /// \brief Retrieve the underlying template declaration that
  /// this template name refers to, if known.
  ///
  /// \returns The template declaration that this template name refers
  /// to, if any. If the template name does not refer to a specific
  /// declaration because it is a dependent name, or if it refers to a
  /// set of function templates, returns NULL.
  
  /// \brief Retrieve the underlying template declaration that
  /// this template name refers to, if known.
  ///
  /// \returns The template declaration that this template name refers
  /// to, if any. If the template name does not refer to a specific
  /// declaration because it is a dependent name, or if it refers to a
  /// set of function templates, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getAsTemplateDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 87,
   FQN="clang::TemplateName::getAsTemplateDecl", NM="_ZNK5clang12TemplateName17getAsTemplateDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName17getAsTemplateDeclEv")
  //</editor-fold>
  public TemplateDecl /*P*/ getAsTemplateDecl() /*const*/ {
    {
      TemplateDecl /*P*/ Template = Storage.dyn_cast(TemplateDecl /*P*/.class);
      if ((Template != null)) {
        return Template;
      }
    }
    {
      
      QualifiedTemplateName /*P*/ QTN = getAsQualifiedTemplateName();
      if ((QTN != null)) {
        return QTN.getTemplateDecl();
      }
    }
    {
      
      SubstTemplateTemplateParmStorage /*P*/ sub = getAsSubstTemplateTemplateParm();
      if ((sub != null)) {
        return sub.getReplacement().getAsTemplateDecl();
      }
    }
    
    return null;
  }


  
  /// \brief Retrieve the underlying, overloaded function template
  // declarations that this template name refers to, if known.
  ///
  /// \returns The set of overloaded function templates that this template
  /// name refers to, if known. If the template name does not refer to a
  /// specific set of function templates because it is a dependent name or
  /// refers to a single template, returns NULL.
  
  /// \brief Retrieve the underlying, overloaded function template
  // declarations that this template name refers to, if known.
  ///
  /// \returns The set of overloaded function templates that this template
  /// name refers to, if known. If the template name does not refer to a
  /// specific set of function templates because it is a dependent name or
  /// refers to a single template, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getAsOverloadedTemplate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 100,
   FQN="clang::TemplateName::getAsOverloadedTemplate", NM="_ZNK5clang12TemplateName23getAsOverloadedTemplateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName23getAsOverloadedTemplateEv")
  //</editor-fold>
  public OverloadedTemplateStorage /*P*/ getAsOverloadedTemplate() /*const*/ {
    {
      UncommonTemplateNameStorage /*P*/ Uncommon = Storage.dyn_cast(UncommonTemplateNameStorage /*P*/.class);
      if ((Uncommon != null)) {
        return Uncommon.getAsOverloadedStorage();
      }
    }
    
    return null;
  }


  
  /// \brief Retrieve the substituted template template parameter, if 
  /// known.
  ///
  /// \returns The storage for the substituted template template parameter,
  /// if known. Otherwise, returns NULL.
  
  /// \brief Retrieve the substituted template template parameter, if 
  /// known.
  ///
  /// \returns The storage for the substituted template template parameter,
  /// if known. Otherwise, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getAsSubstTemplateTemplateParm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 108,
   FQN="clang::TemplateName::getAsSubstTemplateTemplateParm", NM="_ZNK5clang12TemplateName30getAsSubstTemplateTemplateParmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName30getAsSubstTemplateTemplateParmEv")
  //</editor-fold>
  public SubstTemplateTemplateParmStorage /*P*/ getAsSubstTemplateTemplateParm() /*const*/ {
    {
      UncommonTemplateNameStorage /*P*/ uncommon = Storage.dyn_cast(UncommonTemplateNameStorage /*P*/.class);
      if ((uncommon != null)) {
        return uncommon.getAsSubstTemplateTemplateParm();
      }
    }
    
    return null;
  }


  
  /// \brief Retrieve the substituted template template parameter pack, if 
  /// known.
  ///
  /// \returns The storage for the substituted template template parameter pack,
  /// if known. Otherwise, returns NULL.
  
  /// \brief Retrieve the substituted template template parameter pack, if 
  /// known.
  ///
  /// \returns The storage for the substituted template template parameter pack,
  /// if known. Otherwise, returns NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getAsSubstTemplateTemplateParmPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 117,
   FQN="clang::TemplateName::getAsSubstTemplateTemplateParmPack", NM="_ZNK5clang12TemplateName34getAsSubstTemplateTemplateParmPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName34getAsSubstTemplateTemplateParmPackEv")
  //</editor-fold>
  public SubstTemplateTemplateParmPackStorage /*P*/ getAsSubstTemplateTemplateParmPack() /*const*/ {
    {
      UncommonTemplateNameStorage /*P*/ Uncommon = Storage.dyn_cast(UncommonTemplateNameStorage /*P*/.class);
      if ((Uncommon != null)) {
        return Uncommon.getAsSubstTemplateTemplateParmPack();
      }
    }
    
    return null;
  }


  
  /// \brief Retrieve the underlying qualified template name
  /// structure, if any.
  
  /// \brief Retrieve the underlying qualified template name
  /// structure, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getAsQualifiedTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 126,
   FQN="clang::TemplateName::getAsQualifiedTemplateName", NM="_ZNK5clang12TemplateName26getAsQualifiedTemplateNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName26getAsQualifiedTemplateNameEv")
  //</editor-fold>
  public QualifiedTemplateName /*P*/ getAsQualifiedTemplateName() /*const*/ {
    return Storage.dyn_cast(QualifiedTemplateName /*P*/.class);
  }


  
  /// \brief Retrieve the underlying dependent template name
  /// structure, if any.
  
  /// \brief Retrieve the underlying dependent template name
  /// structure, if any.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getAsDependentTemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 130,
   FQN="clang::TemplateName::getAsDependentTemplateName", NM="_ZNK5clang12TemplateName26getAsDependentTemplateNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName26getAsDependentTemplateNameEv")
  //</editor-fold>
  public DependentTemplateName /*P*/ getAsDependentTemplateName() /*const*/ {
    return Storage.dyn_cast(DependentTemplateName /*P*/.class);
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getUnderlying">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 337,
   FQN="clang::TemplateName::getUnderlying", NM="_ZNK5clang12TemplateName13getUnderlyingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZNK5clang12TemplateName13getUnderlyingEv")
  //</editor-fold>
  public /*inline*/ TemplateName getUnderlying() /*const*/ {
    {
      SubstTemplateTemplateParmStorage /*P*/ subst = getAsSubstTemplateTemplateParm();
      if ((subst != null)) {
        return subst.getReplacement().getUnderlying();
      }
    }
    return new TemplateName(/*Deref*/this);
  }

  
  /// \brief Determines whether this is a dependent template name.
  
  /// \brief Determines whether this is a dependent template name.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::isDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 134,
   FQN="clang::TemplateName::isDependent", NM="_ZNK5clang12TemplateName11isDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName11isDependentEv")
  //</editor-fold>
  public boolean isDependent() /*const*/ {
    {
      TemplateDecl /*P*/ Template = getAsTemplateDecl();
      if ((Template != null)) {
        if (isa_TemplateTemplateParmDecl(Template)) {
          return true;
        }
        // FIXME: Hack, getDeclContext() can be null if Template is still
        // initializing due to PCH reading, so we check it before using it.
        // Should probably modify TemplateSpecializationType to allow constructing
        // it without the isDependent() checking.
        return (Template.getDeclContext() != null)
           && Template.getDeclContext().isDependentContext();
      }
    }
    assert (!(getAsOverloadedTemplate() != null)) : "overloaded templates shouldn't survive to here";
    
    return true;
  }


  
  /// \brief Determines whether this is a template name that somehow
  /// depends on a template parameter.
  
  /// \brief Determines whether this is a template name that somehow
  /// depends on a template parameter.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::isInstantiationDependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 152,
   FQN="clang::TemplateName::isInstantiationDependent", NM="_ZNK5clang12TemplateName24isInstantiationDependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName24isInstantiationDependentEv")
  //</editor-fold>
  public boolean isInstantiationDependent() /*const*/ {
    {
      QualifiedTemplateName /*P*/ QTN = getAsQualifiedTemplateName();
      if ((QTN != null)) {
        if (QTN.getQualifier().isInstantiationDependent()) {
          return true;
        }
      }
    }
    
    return isDependent();
  }


  
  /// \brief Determines whether this template name contains an
  /// unexpanded parameter pack (for C++0x variadic templates).
  
  /// \brief Determines whether this template name contains an
  /// unexpanded parameter pack (for C++0x variadic templates).
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::containsUnexpandedParameterPack">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 161,
   FQN="clang::TemplateName::containsUnexpandedParameterPack", NM="_ZNK5clang12TemplateName31containsUnexpandedParameterPackEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName31containsUnexpandedParameterPackEv")
  //</editor-fold>
  public boolean containsUnexpandedParameterPack() /*const*/ {
    {
      TemplateDecl /*P*/ Template = getAsTemplateDecl();
      if ((Template != null)) {
        {
          TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(Template);
          if ((TTP != null)) {
            return TTP.isParameterPack();
          }
        }
        
        return false;
      }
    }
    {
      
      DependentTemplateName /*P*/ DTN = getAsDependentTemplateName();
      if ((DTN != null)) {
        return (DTN.getQualifier() != null)
           && DTN.getQualifier().containsUnexpandedParameterPack();
      }
    }
    
    return getAsSubstTemplateTemplateParmPack() != null;
  }


  
  /// \brief Print the template name.
  ///
  /// \param OS the output stream to which the template name will be
  /// printed.
  ///
  /// \param SuppressNNS if true, don't print the
  /// nested-name-specifier that precedes the template name (if it has
  /// one).
  
  /// \brief Print the template name.
  ///
  /// \param OS the output stream to which the template name will be
  /// printed.
  ///
  /// \param SuppressNNS if true, don't print the
  /// nested-name-specifier that precedes the template name (if it has
  /// one).
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 177,
   FQN="clang::TemplateName::print", NM="_ZNK5clang12TemplateName5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName5printERN4llvm11raw_ostreamERKNS_14PrintingPolicyEb")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    print(OS, Policy, 
       false);
  }
  public void print(final raw_ostream /*&*/ OS, final /*const*/ PrintingPolicy /*&*/ Policy, 
       boolean SuppressNNS/*= false*/) /*const*/ {
    {
      TemplateDecl /*P*/ Template = Storage.dyn_cast(TemplateDecl /*P*/.class);
      if ((Template != null)) {
        $out_raw_ostream_NamedDecl$C(OS, $Deref(Template));
      } else {
        QualifiedTemplateName /*P*/ QTN = getAsQualifiedTemplateName();
        if ((QTN != null)) {
          if (!SuppressNNS) {
            QTN.getQualifier().print(OS, Policy);
          }
          if (QTN.hasTemplateKeyword()) {
            OS.$out(/*KEEP_STR*/"template ");
          }
          $out_raw_ostream_NamedDecl$C(OS, $Deref(QTN.getDecl()));
        } else {
          DependentTemplateName /*P*/ DTN = getAsDependentTemplateName();
          if ((DTN != null)) {
            if (!SuppressNNS && (DTN.getQualifier() != null)) {
              DTN.getQualifier().print(OS, Policy);
            }
            OS.$out(/*KEEP_STR*/"template ");
            if (DTN.isIdentifier()) {
              OS.$out(DTN.getIdentifier().getName());
            } else {
              OS.$out(/*KEEP_STR*/"operator ").$out(getOperatorSpelling(DTN.getOperator()));
            }
          } else {
            SubstTemplateTemplateParmStorage /*P*/ subst = getAsSubstTemplateTemplateParm();
            if ((subst != null)) {
              subst.getReplacement().print(OS, Policy, SuppressNNS);
            } else {
              SubstTemplateTemplateParmPackStorage /*P*/ SubstPack = getAsSubstTemplateTemplateParmPack();
              if ((SubstPack != null)) {
                $out_raw_ostream_NamedDecl$C(OS, $Deref(SubstPack.getParameterPack()));
              } else {
                OverloadedTemplateStorage /*P*/ OTS = getAsOverloadedTemplate();
                (OTS.begin().$star()).printName(OS);
              }
            }
          }
        }
      }
    }
  }


  
  /// \brief Debugging aid that dumps the template name.
  
  /// \brief Debugging aid that dumps the template name.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 223,
   FQN="clang::TemplateName::dump", NM="_ZNK5clang12TemplateName4dumpERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName4dumpERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*/ {
    LangOptions LO/*J*/= new LangOptions(); // FIXME!
    LO.CPlusPlus = true;
    LO.Bool = true;
    print(OS, new PrintingPolicy(LO));
  }


  
  /// \brief Debugging aid that dumps the template name to standard
  /// error.
  
  /// \brief Debugging aid that dumps the template name to standard
  /// error.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 230,
   FQN="clang::TemplateName::dump", NM="_ZNK5clang12TemplateName4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZNK5clang12TemplateName4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs());
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 294,
   FQN="clang::TemplateName::Profile", NM="_ZN5clang12TemplateName7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang12TemplateName7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    ID.AddPointer(Storage.getOpaqueValue());
  }

  
  /// \brief Retrieve the template name as a void pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getAsVoidPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 299,
   FQN="clang::TemplateName::getAsVoidPointer", NM="_ZNK5clang12TemplateName16getAsVoidPointerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZNK5clang12TemplateName16getAsVoidPointerEv")
  //</editor-fold>
  public Object/*void P*/ getAsVoidPointer() /*const*/ {
    return Storage.getOpaqueValue();
  }

  
  /// \brief Build a template name from a void pointer.
  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::getFromVoidPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 302,
   FQN="clang::TemplateName::getFromVoidPointer", NM="_ZN5clang12TemplateName18getFromVoidPointerEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang12TemplateName18getFromVoidPointerEPv")
  //</editor-fold>
  public static TemplateName getFromVoidPointer(Object/*void P*/ Ptr) {
    return new TemplateName(Ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 176,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang12TemplateNameC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateName(final /*const*/ TemplateName /*&*/ $Prm0) {
    // : Storage(.Storage) 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >($Prm0.Storage);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::TemplateName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 176,
   FQN="clang::TemplateName::TemplateName", NM="_ZN5clang12TemplateNameC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang12TemplateNameC1EOS0_")
  //</editor-fold>
  public /*inline*/ TemplateName(JD$Move _dparam, final TemplateName /*&&*/$Prm0) {
    // : Storage(static_cast<TemplateName &&>().Storage) 
    //START JInit
    this.Storage = new PointerUnion4<TemplateDecl /*P*/ , UncommonTemplateNameStorage /*P*/ , QualifiedTemplateName /*P*/ , DependentTemplateName /*P*/ >(JD$Move.INSTANCE, $Prm0.Storage);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 176,
   FQN="clang::TemplateName::operator=", NM="_ZN5clang12TemplateNameaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang12TemplateNameaSERKS0_")
  //</editor-fold>
  public /*inline*/ TemplateName /*&*/ $assign(final /*const*/ TemplateName /*&*/ $Prm0) {
    this.Storage.$assign($Prm0.Storage);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TemplateName::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/TemplateName.h", line = 176,
   FQN="clang::TemplateName::operator=", NM="_ZN5clang12TemplateNameaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang12TemplateNameaSEOS0_")
  //</editor-fold>
  public /*inline*/ TemplateName /*&*/ $assignMove(final TemplateName /*&&*/$Prm0) {
    this.Storage.$assignMove($Prm0.Storage);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Storage=" + Storage; // NOI18N
  }
}
