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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

// \brief Provides info and caches identifiers/selectors for NSFoundation API.
//<editor-fold defaultstate="collapsed" desc="clang::NSAPI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 24,
 FQN="clang::NSAPI", NM="_ZN5clang5NSAPIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPIE")
//</editor-fold>
public class NSAPI {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::NSAPI">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 18,
   FQN="clang::NSAPI::NSAPI", NM="_ZN5clang5NSAPIC1ERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPIC1ERNS_10ASTContextE")
  //</editor-fold>
  public NSAPI(final ASTContext /*&*/ ctx) {
    // : Ctx(ctx), ClassIds(implicit IdentifierInfo * [10]()), NSStringSelectors(), NSArraySelectors(), NSDictionarySelectors(), NSSetSelectors(), NSNumberClassSelectors(), NSNumberInstanceSelectors(), objectForKeyedSubscriptSel(), objectAtIndexedSubscriptSel(), setObjectForKeyedSubscriptSel(), setObjectAtIndexedSubscriptSel(), isEqualSel(), BOOLId(null), NSIntegerId(null), NSUIntegerId(null), NSASCIIStringEncodingId(null), NSUTF8StringEncodingId(null) 
    //START JInit
    this./*&*/Ctx=/*&*/ctx;
    this.ClassIds = /*implicit-init*/new IdentifierInfo /*P*/  [NumClassIds];// {/*zero-init*/0};
    this.NSStringSelectors = new$T(new Selector [5], ()->new Selector());
    this.NSArraySelectors = new$T(new Selector [12], ()->new Selector());
    this.NSDictionarySelectors = new$T(new Selector [14], ()->new Selector());
    this.NSSetSelectors = new$T(new Selector [5], ()->new Selector());
    this.NSNumberClassSelectors = new$T(new Selector [15], ()->new Selector());
    this.NSNumberInstanceSelectors = new$T(new Selector [15], ()->new Selector());
    this.objectForKeyedSubscriptSel = new Selector();
    this.objectAtIndexedSubscriptSel = new Selector();
    this.setObjectForKeyedSubscriptSel = new Selector();
    this.setObjectAtIndexedSubscriptSel = new Selector();
    this.isEqualSel = new Selector();
    this.BOOLId = create_type$ref(null);
    this.NSIntegerId = create_type$ref(null);
    this.NSUIntegerId = create_type$ref(null);
    this.NSASCIIStringEncodingId = create_type$ref(null);
    this.NSUTF8StringEncodingId = create_type$ref(null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getASTContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 28,
   FQN="clang::NSAPI::getASTContext", NM="_ZNK5clang5NSAPI13getASTContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI13getASTContextEv")
  //</editor-fold>
  public ASTContext /*&*/ getASTContext() /*const*/ {
    return Ctx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::NSClassIdKindKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 30,
   FQN="clang::NSAPI::NSClassIdKindKind", NM="_ZN5clang5NSAPI17NSClassIdKindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPI17NSClassIdKindKindE")
  //</editor-fold>
  public enum NSClassIdKindKind implements Native.ComparableLower {
    ClassId_NSObject(0),
    ClassId_NSString(ClassId_NSObject.getValue() + 1),
    ClassId_NSArray(ClassId_NSString.getValue() + 1),
    ClassId_NSMutableArray(ClassId_NSArray.getValue() + 1),
    ClassId_NSDictionary(ClassId_NSMutableArray.getValue() + 1),
    ClassId_NSMutableDictionary(ClassId_NSDictionary.getValue() + 1),
    ClassId_NSNumber(ClassId_NSMutableDictionary.getValue() + 1),
    ClassId_NSMutableSet(ClassId_NSNumber.getValue() + 1),
    ClassId_NSMutableOrderedSet(ClassId_NSMutableSet.getValue() + 1),
    ClassId_NSValue(ClassId_NSMutableOrderedSet.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NSClassIdKindKind valueOf(int val) {
      NSClassIdKindKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NSClassIdKindKind[] VALUES;
      private static final NSClassIdKindKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NSClassIdKindKind kind : NSClassIdKindKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NSClassIdKindKind[min < 0 ? (1-min) : 0];
        VALUES = new NSClassIdKindKind[max >= 0 ? (1+max) : 0];
        for (NSClassIdKindKind kind : NSClassIdKindKind.values()) {
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
    private NSClassIdKindKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NSClassIdKindKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NSClassIdKindKind)obj).value);}
    //</editor-fold>
  };
  public static final /*const*//*uint*/int NumClassIds = 10;
  
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::NSStringMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 44,
   FQN="clang::NSAPI::NSStringMethodKind", NM="_ZN5clang5NSAPI18NSStringMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPI18NSStringMethodKindE")
  //</editor-fold>
  public enum NSStringMethodKind implements Native.ComparableLower {
    NSStr_stringWithString(0),
    NSStr_stringWithUTF8String(NSStr_stringWithString.getValue() + 1),
    NSStr_stringWithCStringEncoding(NSStr_stringWithUTF8String.getValue() + 1),
    NSStr_stringWithCString(NSStr_stringWithCStringEncoding.getValue() + 1),
    NSStr_initWithString(NSStr_stringWithCString.getValue() + 1),
    NSStr_initWithUTF8String(NSStr_initWithString.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NSStringMethodKind valueOf(int val) {
      NSStringMethodKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NSStringMethodKind[] VALUES;
      private static final NSStringMethodKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NSStringMethodKind kind : NSStringMethodKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NSStringMethodKind[min < 0 ? (1-min) : 0];
        VALUES = new NSStringMethodKind[max >= 0 ? (1+max) : 0];
        for (NSStringMethodKind kind : NSStringMethodKind.values()) {
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
    private NSStringMethodKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NSStringMethodKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NSStringMethodKind)obj).value);}
    //</editor-fold>
  };
  public static final /*const*//*uint*/int NumNSStringMethods = 6;// JAVAFIX
  
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSClassId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 23,
   FQN="clang::NSAPI::getNSClassId", NM="_ZNK5clang5NSAPI12getNSClassIdENS0_17NSClassIdKindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI12getNSClassIdENS0_17NSClassIdKindKindE")
  //</editor-fold>
  public IdentifierInfo /*P*/ getNSClassId(NSClassIdKindKind K) /*const*/ {
    final/*static*/ type$ptr</*const*/char$ptr/*char P*/ /*[10]*/> ClassName = getNSClassId$$.ClassName;
    if (!(ClassIds[K.getValue()] != null)) {
      return (ClassIds[K.getValue()] = $AddrOf(Ctx.Idents.get(new StringRef(ClassName.$at(K.getValue())))));
    }
    
    return ClassIds[K.getValue()];
  }
  private static final class getNSClassId$$ {
    static final/*static*/ type$ptr</*const*/char$ptr/*char P*/ /*[10]*/> ClassName = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*10*/] {
      $("NSObject"), 
      $("NSString"), 
      $("NSArray"), 
      $("NSMutableArray"), 
      $("NSDictionary"), 
      $("NSMutableDictionary"), 
      $("NSNumber"), 
      $("NSMutableSet"), 
      $("NSMutableOrderedSet"), 
      $("NSValue")
    });
  }

  
  /// \brief The Objective-C NSString selectors.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSStringSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 43,
   FQN="clang::NSAPI::getNSStringSelector", NM="_ZNK5clang5NSAPI19getNSStringSelectorENS0_18NSStringMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI19getNSStringSelectorENS0_18NSStringMethodKindE")
  //</editor-fold>
  public Selector getNSStringSelector(NSStringMethodKind MK) /*const*/ {
    if (NSStringSelectors[MK.getValue()].isNull()) {
      Selector Sel/*J*/= new Selector();
      switch (MK) {
       case NSStr_stringWithString:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"stringWithString")))));
        break;
       case NSStr_stringWithUTF8String:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"stringWithUTF8String")))));
        break;
       case NSStr_initWithUTF8String:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithUTF8String")))));
        break;
       case NSStr_stringWithCStringEncoding:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"stringWithCString"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"encoding")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSStr_stringWithCString:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"stringWithCString")))));
        break;
       case NSStr_initWithString:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithString")))));
        break;
      }
      return new Selector((NSStringSelectors[MK.getValue()].$assign(Sel)));
    }
    
    return new Selector(NSStringSelectors[MK.getValue()]);
  }

  
  /// \brief Return NSStringMethodKind if \param Sel is such a selector.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSStringMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 79,
   FQN="clang::NSAPI::getNSStringMethodKind", NM="_ZNK5clang5NSAPI21getNSStringMethodKindENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI21getNSStringMethodKindENS_8SelectorE")
  //</editor-fold>
  public Optional<NSAPI.NSStringMethodKind> getNSStringMethodKind(Selector Sel) /*const*/ {
    for (/*uint*/int i = 0; i != NumNSStringMethods; ++i) {
      NSStringMethodKind MK = NSStringMethodKind.valueOf(i);
      if (Sel.$eq(getNSStringSelector(MK))) {
        return new Optional<NSAPI.NSStringMethodKind>(JD$T$C$R.INSTANCE, MK);
      }
    }
    
    return new Optional<NSAPI.NSStringMethodKind>(None);
  }

  
  /// \brief Returns true if the expression \param E is a reference of
  /// "NSUTF8StringEncoding" enum constant.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isNSUTF8StringEncodingConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 64,
   FQN="clang::NSAPI::isNSUTF8StringEncodingConstant", NM="_ZNK5clang5NSAPI30isNSUTF8StringEncodingConstantEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI30isNSUTF8StringEncodingConstantEPKNS_4ExprE")
  //</editor-fold>
  public boolean isNSUTF8StringEncodingConstant(/*const*/ Expr /*P*/ E) /*const*/ {
    return isObjCEnumerator(E, new StringRef(/*KEEP_STR*/"NSUTF8StringEncoding"), NSUTF8StringEncodingId);
  }

  
  /// \brief Returns true if the expression \param E is a reference of
  /// "NSASCIIStringEncoding" enum constant.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isNSASCIIStringEncodingConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 70,
   FQN="clang::NSAPI::isNSASCIIStringEncodingConstant", NM="_ZNK5clang5NSAPI31isNSASCIIStringEncodingConstantEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI31isNSASCIIStringEncodingConstantEPKNS_4ExprE")
  //</editor-fold>
  public boolean isNSASCIIStringEncodingConstant(/*const*/ Expr /*P*/ E) /*const*/ {
    return isObjCEnumerator(E, new StringRef(/*KEEP_STR*/"NSASCIIStringEncoding"), NSASCIIStringEncodingId);
  }

  
  /// \brief Enumerates the NSArray/NSMutableArray methods used to generate
  /// literals and to apply some checks.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::NSArrayMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 76,
   FQN="clang::NSAPI::NSArrayMethodKind", NM="_ZN5clang5NSAPI17NSArrayMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPI17NSArrayMethodKindE")
  //</editor-fold>
  public enum NSArrayMethodKind implements Native.ComparableLower {
    NSArr_array(0),
    NSArr_arrayWithArray(NSArr_array.getValue() + 1),
    NSArr_arrayWithObject(NSArr_arrayWithArray.getValue() + 1),
    NSArr_arrayWithObjects(NSArr_arrayWithObject.getValue() + 1),
    NSArr_arrayWithObjectsCount(NSArr_arrayWithObjects.getValue() + 1),
    NSArr_initWithArray(NSArr_arrayWithObjectsCount.getValue() + 1),
    NSArr_initWithObjects(NSArr_initWithArray.getValue() + 1),
    NSArr_objectAtIndex(NSArr_initWithObjects.getValue() + 1),
    NSMutableArr_replaceObjectAtIndex(NSArr_objectAtIndex.getValue() + 1),
    NSMutableArr_addObject(NSMutableArr_replaceObjectAtIndex.getValue() + 1),
    NSMutableArr_insertObjectAtIndex(NSMutableArr_addObject.getValue() + 1),
    NSMutableArr_setObjectAtIndexedSubscript(NSMutableArr_insertObjectAtIndex.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NSArrayMethodKind valueOf(int val) {
      NSArrayMethodKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NSArrayMethodKind[] VALUES;
      private static final NSArrayMethodKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NSArrayMethodKind kind : NSArrayMethodKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NSArrayMethodKind[min < 0 ? (1-min) : 0];
        VALUES = new NSArrayMethodKind[max >= 0 ? (1+max) : 0];
        for (NSArrayMethodKind kind : NSArrayMethodKind.values()) {
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
    private NSArrayMethodKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NSArrayMethodKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NSArrayMethodKind)obj).value);}
    //</editor-fold>
  };
  public static final /*const*//*uint*/int NumNSArrayMethods = 12;
  
  /// \brief The Objective-C NSArray selectors.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSArraySelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 90,
   FQN="clang::NSAPI::getNSArraySelector", NM="_ZNK5clang5NSAPI18getNSArraySelectorENS0_17NSArrayMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI18getNSArraySelectorENS0_17NSArrayMethodKindE")
  //</editor-fold>
  public Selector getNSArraySelector(NSArrayMethodKind MK) /*const*/ {
    if (NSArraySelectors[MK.getValue()].isNull()) {
      Selector Sel/*J*/= new Selector();
      switch (MK) {
       case NSArr_array:
        Sel.$assignMove(Ctx.Selectors.getNullarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"array")))));
        break;
       case NSArr_arrayWithArray:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"arrayWithArray")))));
        break;
       case NSArr_arrayWithObject:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"arrayWithObject")))));
        break;
       case NSArr_arrayWithObjects:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"arrayWithObjects")))));
        break;
       case NSArr_arrayWithObjectsCount:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"arrayWithObjects"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"count")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSArr_initWithArray:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithArray")))));
        break;
       case NSArr_initWithObjects:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithObjects")))));
        break;
       case NSArr_objectAtIndex:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"objectAtIndex")))));
        break;
       case NSMutableArr_replaceObjectAtIndex:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"replaceObjectAtIndex"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"withObject")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSMutableArr_addObject:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addObject")))));
        break;
       case NSMutableArr_insertObjectAtIndex:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"insertObject"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndex")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSMutableArr_setObjectAtIndexedSubscript:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setObject"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndexedSubscript")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
      }
      return new Selector((NSArraySelectors[MK.getValue()].$assign(Sel)));
    }
    
    return new Selector(NSArraySelectors[MK.getValue()]);
  }

  
  /// \brief Return NSArrayMethodKind if \p Sel is such a selector.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSArrayMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 157,
   FQN="clang::NSAPI::getNSArrayMethodKind", NM="_ZN5clang5NSAPI20getNSArrayMethodKindENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPI20getNSArrayMethodKindENS_8SelectorE")
  //</editor-fold>
  public Optional<NSAPI.NSArrayMethodKind> getNSArrayMethodKind(Selector Sel) {
    for (/*uint*/int i = 0; i != NumNSArrayMethods; ++i) {
      NSArrayMethodKind MK = NSArrayMethodKind.valueOf(i);
      if (Sel.$eq(getNSArraySelector(MK))) {
        return new Optional<NSAPI.NSArrayMethodKind>(JD$T$C$R.INSTANCE, MK);
      }
    }
    
    return new Optional<NSAPI.NSArrayMethodKind>(None);
  }

  
  /// \brief Enumerates the NSDictionary/NSMutableDictionary methods used
  /// to generate literals and to apply some checks.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::NSDictionaryMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 100,
   FQN="clang::NSAPI::NSDictionaryMethodKind", NM="_ZN5clang5NSAPI22NSDictionaryMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPI22NSDictionaryMethodKindE")
  //</editor-fold>
  public enum NSDictionaryMethodKind implements Native.ComparableLower {
    NSDict_dictionary(0),
    NSDict_dictionaryWithDictionary(NSDict_dictionary.getValue() + 1),
    NSDict_dictionaryWithObjectForKey(NSDict_dictionaryWithDictionary.getValue() + 1),
    NSDict_dictionaryWithObjectsForKeys(NSDict_dictionaryWithObjectForKey.getValue() + 1),
    NSDict_dictionaryWithObjectsForKeysCount(NSDict_dictionaryWithObjectsForKeys.getValue() + 1),
    NSDict_dictionaryWithObjectsAndKeys(NSDict_dictionaryWithObjectsForKeysCount.getValue() + 1),
    NSDict_initWithDictionary(NSDict_dictionaryWithObjectsAndKeys.getValue() + 1),
    NSDict_initWithObjectsAndKeys(NSDict_initWithDictionary.getValue() + 1),
    NSDict_initWithObjectsForKeys(NSDict_initWithObjectsAndKeys.getValue() + 1),
    NSDict_objectForKey(NSDict_initWithObjectsForKeys.getValue() + 1),
    NSMutableDict_setObjectForKey(NSDict_objectForKey.getValue() + 1),
    NSMutableDict_setObjectForKeyedSubscript(NSMutableDict_setObjectForKey.getValue() + 1),
    NSMutableDict_setValueForKey(NSMutableDict_setObjectForKeyedSubscript.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NSDictionaryMethodKind valueOf(int val) {
      NSDictionaryMethodKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NSDictionaryMethodKind[] VALUES;
      private static final NSDictionaryMethodKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NSDictionaryMethodKind kind : NSDictionaryMethodKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NSDictionaryMethodKind[min < 0 ? (1-min) : 0];
        VALUES = new NSDictionaryMethodKind[max >= 0 ? (1+max) : 0];
        for (NSDictionaryMethodKind kind : NSDictionaryMethodKind.values()) {
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
    private NSDictionaryMethodKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NSDictionaryMethodKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NSDictionaryMethodKind)obj).value);}
    //</editor-fold>
  };
  public static final /*const*//*uint*/int NumNSDictionaryMethods = 13;// JAVA FIX: must be 13
  
  /// \brief The Objective-C NSDictionary selectors.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSDictionarySelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 167,
   FQN="clang::NSAPI::getNSDictionarySelector", NM="_ZNK5clang5NSAPI23getNSDictionarySelectorENS0_22NSDictionaryMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI23getNSDictionarySelectorENS0_22NSDictionaryMethodKindE")
  //</editor-fold>
  public Selector getNSDictionarySelector(NSDictionaryMethodKind MK) /*const*/ {
    if (NSDictionarySelectors[MK.getValue()].isNull()) {
      Selector Sel/*J*/= new Selector();
      switch (MK) {
       case NSDict_dictionary:
        Sel.$assignMove(Ctx.Selectors.getNullarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"dictionary")))));
        break;
       case NSDict_dictionaryWithDictionary:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"dictionaryWithDictionary")))));
        break;
       case NSDict_dictionaryWithObjectForKey:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"dictionaryWithObject"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forKey")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSDict_dictionaryWithObjectsForKeys:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"dictionaryWithObjects"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forKeys")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSDict_dictionaryWithObjectsForKeysCount:
        {
          IdentifierInfo /*P*/ KeyIdents[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"dictionaryWithObjects"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forKeys"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"count")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(3, create_type$ptr(KeyIdents)));
          break;
        }
       case NSDict_dictionaryWithObjectsAndKeys:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"dictionaryWithObjectsAndKeys")))));
        break;
       case NSDict_initWithDictionary:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithDictionary")))));
        break;
       case NSDict_initWithObjectsAndKeys:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithObjectsAndKeys")))));
        break;
       case NSDict_initWithObjectsForKeys:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"initWithObjects"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forKeys")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSDict_objectForKey:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"objectForKey")))));
        break;
       case NSMutableDict_setObjectForKey:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setObject"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forKey")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSMutableDict_setObjectForKeyedSubscript:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setObject"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forKeyedSubscript")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSMutableDict_setValueForKey:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setValue"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"forKey")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
      }
      return new Selector((NSDictionarySelectors[MK.getValue()].$assign(Sel)));
    }
    
    return new Selector(NSDictionarySelectors[MK.getValue()]);
  }

  
  /// \brief Return NSDictionaryMethodKind if \p Sel is such a selector.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSDictionaryMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 258,
   FQN="clang::NSAPI::getNSDictionaryMethodKind", NM="_ZN5clang5NSAPI25getNSDictionaryMethodKindENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPI25getNSDictionaryMethodKindENS_8SelectorE")
  //</editor-fold>
  public Optional<NSAPI.NSDictionaryMethodKind> getNSDictionaryMethodKind(Selector Sel) {
    for (/*uint*/int i = 0; i != NumNSDictionaryMethods; ++i) {
      NSDictionaryMethodKind MK = NSDictionaryMethodKind.valueOf(i);
      if (Sel.$eq(getNSDictionarySelector(MK))) {
        return new Optional<NSAPI.NSDictionaryMethodKind>(JD$T$C$R.INSTANCE, MK);
      }
    }
    
    return new Optional<NSAPI.NSDictionaryMethodKind>(None);
  }

  
  /// \brief Enumerates the NSMutableSet/NSOrderedSet methods used
  /// to apply some checks.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::NSSetMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 125,
   FQN="clang::NSAPI::NSSetMethodKind", NM="_ZN5clang5NSAPI15NSSetMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPI15NSSetMethodKindE")
  //</editor-fold>
  public enum NSSetMethodKind implements Native.ComparableLower {
    NSMutableSet_addObject(0),
    NSOrderedSet_insertObjectAtIndex(NSMutableSet_addObject.getValue() + 1),
    NSOrderedSet_setObjectAtIndex(NSOrderedSet_insertObjectAtIndex.getValue() + 1),
    NSOrderedSet_setObjectAtIndexedSubscript(NSOrderedSet_setObjectAtIndex.getValue() + 1),
    NSOrderedSet_replaceObjectAtIndexWithObject(NSOrderedSet_setObjectAtIndexedSubscript.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NSSetMethodKind valueOf(int val) {
      NSSetMethodKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NSSetMethodKind[] VALUES;
      private static final NSSetMethodKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NSSetMethodKind kind : NSSetMethodKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NSSetMethodKind[min < 0 ? (1-min) : 0];
        VALUES = new NSSetMethodKind[max >= 0 ? (1+max) : 0];
        for (NSSetMethodKind kind : NSSetMethodKind.values()) {
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
    private NSSetMethodKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NSSetMethodKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NSSetMethodKind)obj).value);}
    //</editor-fold>
  };
  public static final /*const*//*uint*/int NumNSSetMethods = 5;
  
  /// \brief The Objective-C NSSet selectors.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSSetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 269,
   FQN="clang::NSAPI::getNSSetSelector", NM="_ZNK5clang5NSAPI16getNSSetSelectorENS0_15NSSetMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI16getNSSetSelectorENS0_15NSSetMethodKindE")
  //</editor-fold>
  public Selector getNSSetSelector(NSSetMethodKind MK) /*const*/ {
    if (NSSetSelectors[MK.getValue()].isNull()) {
      Selector Sel/*J*/= new Selector();
      switch (MK) {
       case NSMutableSet_addObject:
        Sel.$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"addObject")))));
        break;
       case NSOrderedSet_insertObjectAtIndex:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"insertObject"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndex")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSOrderedSet_setObjectAtIndex:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setObject"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndex")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSOrderedSet_setObjectAtIndexedSubscript:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"setObject"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"atIndexedSubscript")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
       case NSOrderedSet_replaceObjectAtIndexWithObject:
        {
          IdentifierInfo /*P*/ KeyIdents[/*2*/] = new IdentifierInfo /*P*/  [/*2*/] {
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"replaceObjectAtIndex"))), 
            $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"withObject")))
          };
          Sel.$assignMove(Ctx.Selectors.getSelector(2, create_type$ptr(KeyIdents)));
          break;
        }
      }
      return new Selector((NSSetSelectors[MK.getValue()].$assign(Sel)));
    }
    
    return new Selector(NSSetSelectors[MK.getValue()]);
  }

  
  /// \brief Return NSSetMethodKind if \p Sel is such a selector.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSSetMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 315,
   FQN="clang::NSAPI::getNSSetMethodKind", NM="_ZN5clang5NSAPI18getNSSetMethodKindENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPI18getNSSetMethodKindENS_8SelectorE")
  //</editor-fold>
  public Optional<NSAPI.NSSetMethodKind> getNSSetMethodKind(Selector Sel) {
    for (/*uint*/int i = 0; i != NumNSSetMethods; ++i) {
      NSSetMethodKind MK = NSSetMethodKind.valueOf(i);
      if (Sel.$eq(getNSSetSelector(MK))) {
        return new Optional<NSAPI.NSSetMethodKind>(JD$T$C$R.INSTANCE, MK);
      }
    }
    
    return new Optional<NSAPI.NSSetMethodKind>(None);
  }

  
  /// \brief Returns selector for "objectForKeyedSubscript:".
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getObjectForKeyedSubscriptSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 141,
   FQN="clang::NSAPI::getObjectForKeyedSubscriptSelector", NM="_ZNK5clang5NSAPI34getObjectForKeyedSubscriptSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI34getObjectForKeyedSubscriptSelectorEv")
  //</editor-fold>
  public Selector getObjectForKeyedSubscriptSelector() /*const*/ {
    return getOrInitSelector(new ArrayRef<StringRef>(new StringRef(/*KEEP_STR*/"objectForKeyedSubscript"), false), 
        objectForKeyedSubscriptSel);
  }

  
  /// \brief Returns selector for "objectAtIndexedSubscript:".
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getObjectAtIndexedSubscriptSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 147,
   FQN="clang::NSAPI::getObjectAtIndexedSubscriptSelector", NM="_ZNK5clang5NSAPI35getObjectAtIndexedSubscriptSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI35getObjectAtIndexedSubscriptSelectorEv")
  //</editor-fold>
  public Selector getObjectAtIndexedSubscriptSelector() /*const*/ {
    return getOrInitSelector(new ArrayRef<StringRef>(new StringRef(/*KEEP_STR*/"objectAtIndexedSubscript"), false), 
        objectAtIndexedSubscriptSel);
  }

  
  /// \brief Returns selector for "setObject:forKeyedSubscript".
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getSetObjectForKeyedSubscriptSelector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 153,
   FQN="clang::NSAPI::getSetObjectForKeyedSubscriptSelector", NM="_ZNK5clang5NSAPI37getSetObjectForKeyedSubscriptSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI37getSetObjectForKeyedSubscriptSelectorEv")
  //</editor-fold>
  public Selector getSetObjectForKeyedSubscriptSelector() /*const*/ {
    StringRef Ids[/*2*/] = new StringRef [/*2*/] {new StringRef($("setObject")), new StringRef($("forKeyedSubscript"))};
    return getOrInitSelector(new ArrayRef<StringRef>(Ids, false), setObjectForKeyedSubscriptSel);
  }

  
  /// \brief Returns selector for "setObject:atIndexedSubscript".
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getSetObjectAtIndexedSubscriptSelector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 159,
   FQN="clang::NSAPI::getSetObjectAtIndexedSubscriptSelector", NM="_ZNK5clang5NSAPI38getSetObjectAtIndexedSubscriptSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI38getSetObjectAtIndexedSubscriptSelectorEv")
  //</editor-fold>
  public Selector getSetObjectAtIndexedSubscriptSelector() /*const*/ {
    StringRef Ids[/*2*/] = new StringRef [/*2*/] {new StringRef($("setObject")), new StringRef($("atIndexedSubscript"))};
    return getOrInitSelector(new ArrayRef<StringRef>(Ids, false), setObjectAtIndexedSubscriptSel);
  }

  
  /// \brief Returns selector for "isEqual:".
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getIsEqualSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 165,
   FQN="clang::NSAPI::getIsEqualSelector", NM="_ZNK5clang5NSAPI18getIsEqualSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI18getIsEqualSelectorEv")
  //</editor-fold>
  public Selector getIsEqualSelector() /*const*/ {
    return getOrInitSelector(new ArrayRef<StringRef>(new StringRef(/*KEEP_STR*/"isEqual"), false), isEqualSel);
  }

  
  /// \brief Enumerates the NSNumber methods used to generate literals.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::NSNumberLiteralMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 170,
   FQN="clang::NSAPI::NSNumberLiteralMethodKind", NM="_ZN5clang5NSAPI25NSNumberLiteralMethodKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZN5clang5NSAPI25NSNumberLiteralMethodKindE")
  //</editor-fold>
  public enum NSNumberLiteralMethodKind implements Native.ComparableLower {
    NSNumberWithChar(0),
    NSNumberWithUnsignedChar(NSNumberWithChar.getValue() + 1),
    NSNumberWithShort(NSNumberWithUnsignedChar.getValue() + 1),
    NSNumberWithUnsignedShort(NSNumberWithShort.getValue() + 1),
    NSNumberWithInt(NSNumberWithUnsignedShort.getValue() + 1),
    NSNumberWithUnsignedInt(NSNumberWithInt.getValue() + 1),
    NSNumberWithLong(NSNumberWithUnsignedInt.getValue() + 1),
    NSNumberWithUnsignedLong(NSNumberWithLong.getValue() + 1),
    NSNumberWithLongLong(NSNumberWithUnsignedLong.getValue() + 1),
    NSNumberWithUnsignedLongLong(NSNumberWithLongLong.getValue() + 1),
    NSNumberWithFloat(NSNumberWithUnsignedLongLong.getValue() + 1),
    NSNumberWithDouble(NSNumberWithFloat.getValue() + 1),
    NSNumberWithBool(NSNumberWithDouble.getValue() + 1),
    NSNumberWithInteger(NSNumberWithBool.getValue() + 1),
    NSNumberWithUnsignedInteger(NSNumberWithInteger.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NSNumberLiteralMethodKind valueOf(int val) {
      NSNumberLiteralMethodKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NSNumberLiteralMethodKind[] VALUES;
      private static final NSNumberLiteralMethodKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NSNumberLiteralMethodKind kind : NSNumberLiteralMethodKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NSNumberLiteralMethodKind[min < 0 ? (1-min) : 0];
        VALUES = new NSNumberLiteralMethodKind[max >= 0 ? (1+max) : 0];
        for (NSNumberLiteralMethodKind kind : NSNumberLiteralMethodKind.values()) {
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
    private NSNumberLiteralMethodKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NSNumberLiteralMethodKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NSNumberLiteralMethodKind)obj).value);}
    //</editor-fold>
  };
  public static final /*const*//*uint*/int NumNSNumberLiteralMethods = 15;
  
  /// \brief The Objective-C NSNumber selectors used to create NSNumber literals.
  /// \param Instance if true it will return the selector for the init* method
  /// otherwise it will return the selector for the number* method.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSNumberLiteralSelector">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 326,
   FQN="clang::NSAPI::getNSNumberLiteralSelector", NM="_ZNK5clang5NSAPI26getNSNumberLiteralSelectorENS0_25NSNumberLiteralMethodKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI26getNSNumberLiteralSelectorENS0_25NSNumberLiteralMethodKindEb")
  //</editor-fold>
  public Selector getNSNumberLiteralSelector(NSNumberLiteralMethodKind MK, 
                            boolean Instance) /*const*/ {
    final/*static*/ type$ptr</*const*/char$ptr/*char P*/ /*[15]*/> ClassSelectorName = getNSNumberLiteralSelector$$.ClassSelectorName;
    final/*static*/ type$ptr</*const*/char$ptr/*char P*/ /*[15]*/> InstanceSelectorName = getNSNumberLiteralSelector$$.InstanceSelectorName;
    
    Selector /*P*/ Sels[];
    /*const*/type$ptr<char$ptr>/*char PP*/ Names;
    if (Instance) {
      Sels = NSNumberInstanceSelectors;
      Names = $tryClone(InstanceSelectorName);
    } else {
      Sels = NSNumberClassSelectors;
      Names = $tryClone(ClassSelectorName);
    }
    if (Sels[MK.getValue()].isNull()) {
      Sels[MK.getValue()].$assignMove(Ctx.Selectors.getUnarySelector($AddrOf(Ctx.Idents.get(new StringRef(Names.$at(MK.getValue()))))));
    }
    return new Selector(Sels[MK.getValue()]);
  }
  private static final class getNSNumberLiteralSelector$$ {
    static final/*static*/ type$ptr</*const*/char$ptr/*char P*/ /*[15]*/> ClassSelectorName = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*15*/] {
      $("numberWithChar"), 
      $("numberWithUnsignedChar"), 
      $("numberWithShort"), 
      $("numberWithUnsignedShort"), 
      $("numberWithInt"), 
      $("numberWithUnsignedInt"), 
      $("numberWithLong"), 
      $("numberWithUnsignedLong"), 
      $("numberWithLongLong"), 
      $("numberWithUnsignedLongLong"), 
      $("numberWithFloat"), 
      $("numberWithDouble"), 
      $("numberWithBool"), 
      $("numberWithInteger"), 
      $("numberWithUnsignedInteger")
    });
    static final/*static*/ type$ptr</*const*/char$ptr/*char P*/ /*[15]*/> InstanceSelectorName = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*15*/] {
      $("initWithChar"), 
      $("initWithUnsignedChar"), 
      $("initWithShort"), 
      $("initWithUnsignedShort"), 
      $("initWithInt"), 
      $("initWithUnsignedInt"), 
      $("initWithLong"), 
      $("initWithUnsignedLong"), 
      $("initWithLongLong"), 
      $("initWithUnsignedLongLong"), 
      $("initWithFloat"), 
      $("initWithDouble"), 
      $("initWithBool"), 
      $("initWithInteger"), 
      $("initWithUnsignedInteger")
    });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isNSNumberLiteralSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NSAPI.h", line = 195,
   FQN="clang::NSAPI::isNSNumberLiteralSelector", NM="_ZNK5clang5NSAPI25isNSNumberLiteralSelectorENS0_25NSNumberLiteralMethodKindENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI25isNSNumberLiteralSelectorENS0_25NSNumberLiteralMethodKindENS_8SelectorE")
  //</editor-fold>
  public boolean isNSNumberLiteralSelector(NSNumberLiteralMethodKind MK, 
                           Selector Sel) /*const*/ {
    return Sel.$eq(getNSNumberLiteralSelector(MK, false))
       || Sel.$eq(getNSNumberLiteralSelector(MK, true));
  }

  
  /// \brief Return NSNumberLiteralMethodKind if \p Sel is such a selector.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSNumberLiteralMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 378,
   FQN="clang::NSAPI::getNSNumberLiteralMethodKind", NM="_ZNK5clang5NSAPI28getNSNumberLiteralMethodKindENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI28getNSNumberLiteralMethodKindENS_8SelectorE")
  //</editor-fold>
  public Optional<NSAPI.NSNumberLiteralMethodKind> getNSNumberLiteralMethodKind(Selector Sel) /*const*/ {
    for (/*uint*/int i = 0; i != NumNSNumberLiteralMethods; ++i) {
      NSNumberLiteralMethodKind MK = NSNumberLiteralMethodKind.valueOf(i);
      if (isNSNumberLiteralSelector(MK, new Selector(Sel))) {
        return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$C$R.INSTANCE, MK);
      }
    }
    
    return new Optional<NSAPI.NSNumberLiteralMethodKind>(None);
  }

  
  /// \brief Determine the appropriate NSNumber factory method kind for a
  /// literal of the given type.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getNSNumberFactoryMethodKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 389,
   FQN="clang::NSAPI::getNSNumberFactoryMethodKind", NM="_ZNK5clang5NSAPI28getNSNumberFactoryMethodKindENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI28getNSNumberFactoryMethodKindENS_8QualTypeE")
  //</editor-fold>
  public Optional<NSAPI.NSNumberLiteralMethodKind> getNSNumberFactoryMethodKind(QualType T) /*const*/ {
    /*const*/ BuiltinType /*P*/ BT = T.$arrow().getAs$BuiltinType();
    if (!(BT != null)) {
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(None);
    }
    
    /*const*/ TypedefType /*P*/ TDT = T.$arrow().getAs$TypedefType();
    if ((TDT != null)) {
      QualType TDTTy = new QualType(TDT, 0);
      if (isObjCBOOLType(new QualType(TDTTy))) {
        return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithBool);
      }
      if (isObjCNSIntegerType(new QualType(TDTTy))) {
        return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithInteger);
      }
      if (isObjCNSUIntegerType(new QualType(TDTTy))) {
        return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithUnsignedInteger);
      }
    }
    switch (BT.getKind()) {
     case Char_S:
     case SChar:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithChar);
     case Char_U:
     case UChar:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithUnsignedChar);
     case Short:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithShort);
     case UShort:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithUnsignedShort);
     case Int:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithInt);
     case UInt:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithUnsignedInt);
     case Long:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithLong);
     case ULong:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithUnsignedLong);
     case LongLong:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithLongLong);
     case ULongLong:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithUnsignedLongLong);
     case Float:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithFloat);
     case Double:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithDouble);
     case Bool:
      return new Optional<NSAPI.NSNumberLiteralMethodKind>(JD$T$RR.INSTANCE, NSAPI.NSNumberLiteralMethodKind.NSNumberWithBool);
     case Void:
     case WChar_U:
     case WChar_S:
     case Char16:
     case Char32:
     case Int128:
     case LongDouble:
     case UInt128:
     case Float128:
     case NullPtr:
     case ObjCClass:
     case ObjCId:
     case ObjCSel:
     case OCLImage1dRO:
     case OCLImage1dArrayRO:
     case OCLImage1dBufferRO:
     case OCLImage2dRO:
     case OCLImage2dArrayRO:
     case OCLImage2dDepthRO:
     case OCLImage2dArrayDepthRO:
     case OCLImage2dMSAARO:
     case OCLImage2dArrayMSAARO:
     case OCLImage2dMSAADepthRO:
     case OCLImage2dArrayMSAADepthRO:
     case OCLImage3dRO:
     case OCLImage1dWO:
     case OCLImage1dArrayWO:
     case OCLImage1dBufferWO:
     case OCLImage2dWO:
     case OCLImage2dArrayWO:
     case OCLImage2dDepthWO:
     case OCLImage2dArrayDepthWO:
     case OCLImage2dMSAAWO:
     case OCLImage2dArrayMSAAWO:
     case OCLImage2dMSAADepthWO:
     case OCLImage2dArrayMSAADepthWO:
     case OCLImage3dWO:
     case OCLImage1dRW:
     case OCLImage1dArrayRW:
     case OCLImage1dBufferRW:
     case OCLImage2dRW:
     case OCLImage2dArrayRW:
     case OCLImage2dDepthRW:
     case OCLImage2dArrayDepthRW:
     case OCLImage2dMSAARW:
     case OCLImage2dArrayMSAARW:
     case OCLImage2dMSAADepthRW:
     case OCLImage2dArrayMSAADepthRW:
     case OCLImage3dRW:
     case OCLSampler:
     case OCLEvent:
     case OCLClkEvent:
     case OCLQueue:
     case OCLNDRange:
     case OCLReserveID:
     case BoundMember:
     case Dependent:
     case Overload:
     case UnknownAny:
     case ARCUnbridgedCast:
     case Half:
     case PseudoObject:
     case BuiltinFn:
     case OMPArraySection:
      break;
    }
    
    return new Optional<NSAPI.NSNumberLiteralMethodKind>(None);
  }

  
  /// \brief Returns true if \param T is a typedef of "BOOL" in objective-c.
  
  /// \brief Returns true if \param T is a typedef of "BOOL" in objective-c.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isObjCBOOLType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 474,
   FQN="clang::NSAPI::isObjCBOOLType", NM="_ZNK5clang5NSAPI14isObjCBOOLTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI14isObjCBOOLTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean isObjCBOOLType(QualType T) /*const*/ {
    return isObjCTypedef(new QualType(T), new StringRef(/*KEEP_STR*/"BOOL"), BOOLId);
  }

  /// \brief Returns true if \param T is a typedef of "NSInteger" in objective-c.
  /// \brief Returns true if \param T is a typedef of "NSInteger" in objective-c.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isObjCNSIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 478,
   FQN="clang::NSAPI::isObjCNSIntegerType", NM="_ZNK5clang5NSAPI19isObjCNSIntegerTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI19isObjCNSIntegerTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean isObjCNSIntegerType(QualType T) /*const*/ {
    return isObjCTypedef(new QualType(T), new StringRef(/*KEEP_STR*/"NSInteger"), NSIntegerId);
  }

  /// \brief Returns true if \param T is a typedef of "NSUInteger" in objective-c.
  /// \brief Returns true if \param T is a typedef of "NSUInteger" in objective-c.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isObjCNSUIntegerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 482,
   FQN="clang::NSAPI::isObjCNSUIntegerType", NM="_ZNK5clang5NSAPI20isObjCNSUIntegerTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI20isObjCNSUIntegerTypeENS_8QualTypeE")
  //</editor-fold>
  public boolean isObjCNSUIntegerType(QualType T) /*const*/ {
    return isObjCTypedef(new QualType(T), new StringRef(/*KEEP_STR*/"NSUInteger"), NSUIntegerId);
  }

  /// \brief Returns one of NSIntegral typedef names if \param T is a typedef
  /// of that name in objective-c.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::GetNSIntegralKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 486,
   FQN="clang::NSAPI::GetNSIntegralKind", NM="_ZNK5clang5NSAPI17GetNSIntegralKindENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI17GetNSIntegralKindENS_8QualTypeE")
  //</editor-fold>
  public StringRef GetNSIntegralKind(QualType T) /*const*/ {
    if (!Ctx.getLangOpts().ObjC1 || T.isNull()) {
      return new StringRef();
    }
    {
      
      /*const*/ TypedefType /*P*/ TDT;
      while (((/*P*/ TDT = T.$arrow().getAs$TypedefType()) != null)) {
        StringRef NSIntegralResust = new StringSwitchStringRef(TDT.getDecl().getDeclName().getAsIdentifierInfo().getName()).
            Case(/*KEEP_STR*/"int8_t", /*STRINGREF_STR*/"int8_t").
            Case(/*KEEP_STR*/"int16_t", /*STRINGREF_STR*/"int16_t").
            Case(/*KEEP_STR*/"int32_t", /*STRINGREF_STR*/"int32_t").
            Case(/*KEEP_STR*/"NSInteger", /*STRINGREF_STR*/"NSInteger").
            Case(/*KEEP_STR*/"int64_t", /*STRINGREF_STR*/"int64_t").
            Case(/*KEEP_STR*/"uint8_t", /*STRINGREF_STR*/"uint8_t").
            Case(/*KEEP_STR*/"uint16_t", /*STRINGREF_STR*/"uint16_t").
            Case(/*KEEP_STR*/"uint32_t", /*STRINGREF_STR*/"uint32_t").
            Case(/*KEEP_STR*/"NSUInteger", /*STRINGREF_STR*/"NSUInteger").
            Case(/*KEEP_STR*/"uint64_t", /*STRINGREF_STR*/"uint64_t").
            Default(new StringRef());
        if (!NSIntegralResust.empty()) {
          return NSIntegralResust;
        }
        T.$assignMove(TDT.desugar());
      }
    }
    return new StringRef();
  }

  
  /// \brief Returns \c true if \p Id is currently defined as a macro.
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isMacroDefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 512,
   FQN="clang::NSAPI::isMacroDefined", NM="_ZNK5clang5NSAPI14isMacroDefinedEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI14isMacroDefinedEN4llvm9StringRefE")
  //</editor-fold>
  public boolean isMacroDefined(StringRef Id) /*const*/ {
    // FIXME: Check whether the relevant module macros are visible.
    return Ctx.Idents.get(/*NO_COPY*/Id).hasMacroDefinition();
  }

  
  /// \brief Returns \c true if \p InterfaceDecl is subclass of \p NSClassKind
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isSubclassOfNSClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 517,
   FQN="clang::NSAPI::isSubclassOfNSClass", NM="_ZNK5clang5NSAPI19isSubclassOfNSClassEPNS_17ObjCInterfaceDeclENS0_17NSClassIdKindKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI19isSubclassOfNSClassEPNS_17ObjCInterfaceDeclENS0_17NSClassIdKindKindE")
  //</editor-fold>
  public boolean isSubclassOfNSClass(ObjCInterfaceDecl /*P*/ InterfaceDecl, 
                     NSClassIdKindKind NSClassKind) /*const*/ {
    if (!(InterfaceDecl != null)) {
      return false;
    }
    
    IdentifierInfo /*P*/ NSClassID = getNSClassId(NSClassKind);
    
    boolean IsSubclass = false;
    do {
      IsSubclass = NSClassID == InterfaceDecl.getIdentifier();
      if (IsSubclass) {
        break;
      }
    } while (((InterfaceDecl = InterfaceDecl.getSuperClass()) != null));
    
    return IsSubclass;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isObjCTypedef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 537,
   FQN="clang::NSAPI::isObjCTypedef", NM="_ZNK5clang5NSAPI13isObjCTypedefENS_8QualTypeEN4llvm9StringRefERPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI13isObjCTypedefENS_8QualTypeEN4llvm9StringRefERPNS_14IdentifierInfoE")
  //</editor-fold>
  private boolean isObjCTypedef(QualType T, 
               StringRef name, final type$ref<IdentifierInfo /*P*/ /*&*/> II) /*const*/ {
    if (!Ctx.getLangOpts().ObjC1) {
      return false;
    }
    if (T.isNull()) {
      return false;
    }
    if (!(II.$deref() != null)) {
      II.$set($AddrOf(Ctx.Idents.get(/*NO_COPY*/name)));
    }
    {
      
      /*const*/ TypedefType /*P*/ TDT;
      while (((/*P*/ TDT = T.$arrow().getAs$TypedefType()) != null)) {
        if (TDT.getDecl().getDeclName().getAsIdentifierInfo() == II.$deref()) {
          return true;
        }
        T.$assignMove(TDT.desugar());
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::isObjCEnumerator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 556,
   FQN="clang::NSAPI::isObjCEnumerator", NM="_ZNK5clang5NSAPI16isObjCEnumeratorEPKNS_4ExprEN4llvm9StringRefERPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI16isObjCEnumeratorEPKNS_4ExprEN4llvm9StringRefERPNS_14IdentifierInfoE")
  //</editor-fold>
  private boolean isObjCEnumerator(/*const*/ Expr /*P*/ E, 
                  StringRef name, final type$ref<IdentifierInfo /*P*/ /*&*/> II) /*const*/ {
    if (!Ctx.getLangOpts().ObjC1) {
      return false;
    }
    if (!(E != null)) {
      return false;
    }
    if (!(II.$deref() != null)) {
      II.$set($AddrOf(Ctx.Idents.get(/*NO_COPY*/name)));
    }
    {
      
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E.IgnoreParenImpCasts$Const());
      if ((DRE != null)) {
        {
          /*const*/ EnumConstantDecl /*P*/ EnumD = dyn_cast_or_null_EnumConstantDecl(DRE.getDecl$Const());
          if ((EnumD != null)) {
            return EnumD.getIdentifier() == II.$deref();
          }
        }
      }
    }
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::NSAPI::getOrInitSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp", line = 574,
   FQN="clang::NSAPI::getOrInitSelector", NM="_ZNK5clang5NSAPI17getOrInitSelectorEN4llvm8ArrayRefINS1_9StringRefEEERNS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/NSAPI.cpp -nm=_ZNK5clang5NSAPI17getOrInitSelectorEN4llvm8ArrayRefINS1_9StringRefEEERNS_8SelectorE")
  //</editor-fold>
  private Selector getOrInitSelector(ArrayRef<StringRef> Ids, 
                   final Selector /*&*/ Sel) /*const*/ {
    if (Sel.isNull()) {
      SmallVector<IdentifierInfo /*P*/> Idents/*J*/= new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
      for (type$ptr<StringRef> I = $tryClone(Ids.begin()), /*P*/ E = $tryClone(Ids.end()); $noteq_ptr(I, E); I.$preInc())  {
        Idents.push_back($AddrOf(Ctx.Idents.get(/*NO_COPY*/I.$star())));
      }
      Sel.$assignMove(Ctx.Selectors.getSelector(Idents.size(), Idents.data()));
    }
    return new Selector(Sel);
  }

  
  private final ASTContext /*&*/ Ctx;
  
  private /*mutable */IdentifierInfo /*P*/ ClassIds[/*NumClassIds*/] = new IdentifierInfo /*P*/  [NumClassIds];
  
  private /*mutable */Selector NSStringSelectors[/*NumNSStringMethods*/] = new Selector [NumNSStringMethods];
  
  /// \brief The selectors for Objective-C NSArray methods.
  private /*mutable */Selector NSArraySelectors[/*NumNSArrayMethods*/] = new Selector [NumNSArrayMethods];
  
  /// \brief The selectors for Objective-C NSDictionary methods.
  private /*mutable */Selector NSDictionarySelectors[/*NumNSDictionaryMethods*/] = new Selector [NumNSDictionaryMethods];
  
  /// \brief The selectors for Objective-C NSSet methods.
  private /*mutable */Selector NSSetSelectors[/*NumNSSetMethods*/] = new Selector [NumNSSetMethods];
  
  /// \brief The Objective-C NSNumber selectors used to create NSNumber literals.
  private /*mutable */Selector NSNumberClassSelectors[/*NumNSNumberLiteralMethods*/] = new Selector [NumNSNumberLiteralMethods];
  private /*mutable */Selector NSNumberInstanceSelectors[/*NumNSNumberLiteralMethods*/] = new Selector [NumNSNumberLiteralMethods];
  
  private /*mutable */Selector objectForKeyedSubscriptSel;
  
  private /*mutable */Selector objectAtIndexedSubscriptSel;
  
  private /*mutable */Selector setObjectForKeyedSubscriptSel;
  
  private /*mutable */Selector setObjectAtIndexedSubscriptSel;
  
  private /*mutable */Selector isEqualSel;

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private /*mutable */type$ref<IdentifierInfo /*P*/> BOOLId;
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private /*mutable */type$ref<IdentifierInfo /*P*/> NSIntegerId;
  
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private /*mutable */type$ref<IdentifierInfo /*P*/> NSUIntegerId;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private /*mutable */type$ref<IdentifierInfo /*P*/> NSASCIIStringEncodingId;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private /*mutable */type$ref<IdentifierInfo /*P*/> NSUTF8StringEncodingId;
  
  @Override public String toString() {
    return "" + "Ctx=" + "[ASTContext]" // NOI18N
              + ", ClassIds=" + ClassIds // NOI18N
              + ", NSStringSelectors=" + NSStringSelectors // NOI18N
              + ", NSArraySelectors=" + NSArraySelectors // NOI18N
              + ", NSDictionarySelectors=" + NSDictionarySelectors // NOI18N
              + ", NSSetSelectors=" + NSSetSelectors // NOI18N
              + ", NSNumberClassSelectors=" + NSNumberClassSelectors // NOI18N
              + ", NSNumberInstanceSelectors=" + NSNumberInstanceSelectors // NOI18N
              + ", objectForKeyedSubscriptSel=" + objectForKeyedSubscriptSel // NOI18N
              + ", objectAtIndexedSubscriptSel=" + objectAtIndexedSubscriptSel // NOI18N
              + ", setObjectForKeyedSubscriptSel=" + setObjectForKeyedSubscriptSel // NOI18N
              + ", setObjectAtIndexedSubscriptSel=" + setObjectAtIndexedSubscriptSel // NOI18N
              + ", isEqualSel=" + isEqualSel // NOI18N
              + ", BOOLId=" + BOOLId // NOI18N
              + ", NSIntegerId=" + NSIntegerId // NOI18N
              + ", NSUIntegerId=" + NSUIntegerId // NOI18N
              + ", NSASCIIStringEncodingId=" + NSASCIIStringEncodingId // NOI18N
              + ", NSUTF8StringEncodingId=" + NSUTF8StringEncodingId; // NOI18N
  }
}
